package com.wuxiaolong.androidmvpsample.bean;

/**
 * Created by LZZ on 2017/8/31.
 */

public class Banli {

    /**
     * jsonInfo : {"code":"1","data":"","msg":"此房间不能办理入住"}
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
         * code : 1
         * data :
         * msg : 此房间不能办理入住
         */

        private String code;
        private String data;
        private String msg;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}
