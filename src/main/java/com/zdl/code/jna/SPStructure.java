package com.zdl.code.jna;

import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

/**
 * Created by z02464 on 2016/11/21.
 */
public interface SPStructure {

    /**
     * @class tagCommonQueryCondition
     * @brief 通用查询条件
     * @attention
     */
    class SPS_COMMON_QUERY_CONDITION_S extends Structure {
        /**
         * 查询条件数组中查询条件的实际个数, 最大取值为#ZDL_SPS_QUERY_ITEM_MAX_NUM
         */
        public int ulItemNum;

        /**
         * 查询条件数组
         */
        public SPS_QUERY_CONDITION_ITEM_S[] astQueryConditionList;

        public SPS_COMMON_QUERY_CONDITION_S() {
            astQueryConditionList = (SPS_QUERY_CONDITION_ITEM_S[]) (new SPS_QUERY_CONDITION_ITEM_S()).toArray(SDKConst.ZDL_QUERY_ITEM_MAX_NUM);
        }

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("ulItemNum", "astQueryConditionList");
        }

    }

    /**
     * @class tagSPSQueryConditionItem
     * @brief 查询条件项
     * @attention
     */
     class SPS_QUERY_CONDITION_ITEM_S extends Structure {
        /**
         * 查询条件列名
         */
        public byte[] szQueryColumn = new byte[SDKConst.ZDL_QUERY_DATA_MAX_LEN];

        /**
         * 查询条件逻辑关系类型: #LOGIC_FLAG_E
         * ulLogicFlag = 99,表示IN,此时查询条件
         * 由客户端自己组合szQueryDate,需加"()"
         * 例如: "(1,1001)"
         */
        public int ulLogicFlag;

        /**
         * 查询条件
         */
        public byte[] szQueryData = new byte[SDKConst.ZDL_QUERY_DATA_MAX_LEN];

        public SPS_QUERY_CONDITION_ITEM_S() {

        }

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("szQueryColumn", "ulLogicFlag", "szQueryData");
        }
    }

    /**
     * 人脸布控报警
     */
    class SPS_FACE_ALARM_S extends Structure {
        /**
         * 人脸报警ID
         */
        public byte[] szId = new byte[SDKConst.ZDL_CODE_LEN];

        /**
         * 人脸抓拍图片ID
         */
        public byte[] szSnappicId = new byte[SDKConst.ZDL_CODE_LEN];

        /**
         * 产生报警的布控id
         */
        public byte[] szGuardtaskId = new byte[SDKConst.ZDL_CODE_LEN];

        /**
         * 人脸相机编码
         */
        public byte[] szFacecamCode = new byte[SDKConst.ZDL_CODE_LEN];

        /**
         * 报警时间
         */
        public byte[] szAlarmTime = new byte[SDKConst.ZDL_TIME_LEN];

        /**
         * 报警类型
         */
        public byte[] szAlarmType = new byte[SDKConst.ZDL_CODE_LEN];

        /**
         * 布控列管原因
         */
        public byte[] szGuardReason = new byte[SDKConst.ZDL_DESC_LEN];

        /**
         * 布控列管类型
         */
        public byte[] szGuardType = new byte[SDKConst.ZDL_DESC_LEN];

        /**
         * 布控的对比库
         */
        public byte[] szFacelibId = new byte[SDKConst.ZDL_CODE_LEN];

        /**
         * 人脸名单编号
         */
        public byte[] szFaceId = new byte[SDKConst.ZDL_CODE_LEN];

        /**
         * 名单库人脸url
         */
        public byte[] szFacePicurl = new byte[SDKConst.ZDL_URL_LEN];

        /**
         * 人脸抓拍图片url
         */
        public byte[] szSnapPicurl = new byte[SDKConst.ZDL_URL_LEN];

        /**
         * 人脸相似度
         */
        public int nFaceSamevalue;

        /**
         * 人脸抓拍小图片url
         */
        public byte[] szSnapfacePicurl = new byte[SDKConst.ZDL_URL_LEN];

        /**
         * 人脸国籍
         */
        public byte[] szFaceCountry = new byte[SDKConst.ZDL_DESC_LEN];

        /**
         * 人脸省份
         */
        public byte[] szFaceProvince = new byte[SDKConst.ZDL_DESC_LEN];

        /**
         * 人脸城市
         */
        public byte[] szFaceCity = new byte[SDKConst.ZDL_DESC_LEN];

        /**
         * 证件类型
         */
        public int nFaceIdtype;

        /**
         * 证件ID
         */
        public byte[] szFaceCardid = new byte[SDKConst.ZDL_CODE_LEN];

        /**
         * 性别
         */
        public int nFaceGender;

        /**
         * 年龄
         */
        public int nFaceAge;

        /**
         * 姓名
         */
        public byte[] szFaceName = new byte[SDKConst.ZDL_NAME_LEN];

        /**
         * 出生日期
         */
        public byte[] szFaceBirthday = new byte[SDKConst.ZDL_TIME_LEN];

        /**
         * 人脸抓拍时间
         */
        public byte[] szSnapTime = new byte[SDKConst.ZDL_TIME_LEN];

        /**
         * 人脸在图片中位置
         */
        public byte[] szFacePlaction = new byte[SDKConst.ZDL_CODE_LEN];

        public SPS_FACE_ALARM_S() {

        }

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("szId", "szSnappicId", "szGuardtaskId", "szFacecamCode", "szAlarmTime",
                    "szAlarmType", "szGuardReason", "szGuardType", "szFacelibId", "szFaceId", "szFacePicurl",
                    "szSnapPicurl", "nFaceSamevalue", "szSnapfacePicurl", "szFaceCountry", "szFaceProvince",
                    "szFaceCity", "nFaceIdtype", "szFaceCardid", "nFaceGender", "nFaceAge", "szFaceName",
                    "szFaceBirthday", "szSnapTime", "szFacePlaction");
        }
    }

    /**
     * 人脸抓拍信息
     */
    class SPS_FACESNAP_INFO_S extends Structure {
        /**
         * 人脸抓拍图片ID
         */
        public byte[] szId = new byte[SDKConst.ZDL_CODE_LEN];

        /**
         * 人脸相机编码
         */
        public byte[] szFacecamCode = new byte[SDKConst.ZDL_CODE_LEN];

        /**
         * 人脸抓拍时间
         */
        public byte[] szSnapTime = new byte[SDKConst.ZDL_TIME_LEN];

        /**
         * 人脸抓拍图片url
         */
        public byte[] szSnapPicurl = new byte[SDKConst.ZDL_URL_LEN];

        /**
         * 人脸在图片中位置
         */
        public byte[] szFacePlaction = new byte[SDKConst.ZDL_CODE_LEN];

        /**
         * 人脸小图url
         */
        public byte[] szFacePicurl = new byte[SDKConst.ZDL_URL_LEN];

        /**
         * 人脸特征库
         */
        public byte[] szFacelibId = new byte[SDKConst.ZDL_CODE_LEN];

        /**
         * 性别
         */
        public int ulGender;

        /**
         * 年龄
         */
        public int ulAge;

        /**
         * 是否戴眼镜
         */
        public int ulWearGlasses;

        /**
         * 是否微笑
         */
        public int ulSmile;

        /**
         * 开心指数
         */
        public int ulHappyIndex;

        /**
         * 民族 0--非维族， 1--维族
         */
        public int ulNation;

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("szId", "szFacecamCode", "szSnapTime", "szSnapPicurl",
                    "szFacePlaction", "szFacePicurl", "szFacelibId", "ulGender", "ulAge",
                    "ulWearGlasses", "ulSmile", "ulHappyIndex", "ulNation");
        }
    }
}
