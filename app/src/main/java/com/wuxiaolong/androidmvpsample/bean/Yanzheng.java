package com.wuxiaolong.androidmvpsample.bean;

/**
 * Created by LZZ on 2017/8/28.
 */

public class Yanzheng {


    /**
     * jsonInfo : {"code":"0","data":{"isConfirm":"1","isCheck":"0"},"msg":"此客房不能收银"}
     */

    private JsonInfoBean jsonInfo;

    public JsonInfoBean getJsonInfo() {
        return jsonInfo;
    }

    public void setJsonInfo(JsonInfoBean jsonInfo) {
        this.jsonInfo = jsonInfo;
    }

    public static class JsonInfoBean {
        /**
         * code : 0
         * data : {"isConfirm":"1","isCheck":"0"}
         * msg : 此客房不能收银
         */

        private String code;
        private DataBean data;
        private String msg;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public static class DataBean {
            /**
             * isConfirm : 1
             * isCheck : 0
             */

            private String isConfirm;
            private String isCheck;

            public String getIsConfirm() {
                return isConfirm;
            }

            public void setIsConfirm(String isConfirm) {
                this.isConfirm = isConfirm;
            }

            public String getIsCheck() {
                return isCheck;
            }

            public void setIsCheck(String isCheck) {
                this.isCheck = isCheck;
            }
        }
    }
}
