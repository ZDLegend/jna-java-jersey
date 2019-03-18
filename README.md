# jna-java-jersey
----------------------------
## 0.摘要
### 0.0 说明
这是我2016年开始学习java以来第一个完全由自己负责，由自己设计业务结构的项目。

上传之前做了部分改动。

该工程主要业务是通过jna掉用C++库，由C++ SDK api转换成restful api。

### 0.1 基本流程
* C++接口转换成JNA java结构（见1.0）后，根据接口特性，继承包com.zdl.code.api中的接口类进行再封装。

* 数据由com.zdl.code.controller包中进入，由com.zdl.code.service.CommonService统一调用封装后的jna C++接口。

* 中间json数据和结构体之间的转换由类com.zdl.code.server.StructUtils转换。

## 1.jna封装C++
### 1.0 函数转换
> C++函数
```
__declspec( dllexport ) ULONG_31 STDCALL SDK_Login 
( 
    IN  CHAR           szUserLoginName[ZDL_NAME_LEN], 
    IN  CHAR           szPassword[ZDL_PASSWD_ENCRYPT_LEN], 
    IN  CHAR           szIpAddress[ZDL_IPADDR_LEN], 
    OUT LOGIN_INFO_S   *pstSDKLoginInfo 
); 
```
> 转换成java方法
```
int SDK_Login(byte[] szUserLoginName, byte[] szPassword, byte[] szIpAddress, SDKStructure.LOGIN_INFO_S pstSDKLoginInfo); 
```
### 1.1 结构体与类间转换
> C++结构体
```
typedef struct tagLoginInfo 
{ 
    USER_LOGIN_ID_INFO_S stUserLoginIDInfo; 
    CHAR szOrgCode[48]; 
    CHAR szDomainName[64]; 
    ULONG_31 ulDomainType; 
}LOGIN_INFO_S;
```
> 转换成java类
```
public static class LOGIN_INFO_S extends Structure {
    
    public USER_LOGIN_ID_INFO_S stUserLoginIDInfo= new USER_LOGIN_ID_INFO_S();
    public byte[] szOrgCode  = new byte[48];
    public byte[] szDomainName  = new byte[64];
    public int ulDomainType;
	
    public LOGIN_INFO_S() {
    }  
	
	@Override    
	protected List<String> getFieldOrder() {   
	    return Arrays.asList(new String[]{"stUserLoginIDInfo","szOrgCode","szDomainName","ulDomainType",}); 
	}
}
```
