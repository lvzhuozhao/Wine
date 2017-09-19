package com.wuxiaolong.androidmvpsample.bean;

/**
 * Created by LZZ on 2017/9/5.
 */

public class Wen_price {

    /**
     * jsonInfo : {"code":"0","data":{"price":"50.0"},"msg":"成功"}
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
         * data : {"price":"50.0"}
         * msg : 成功
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
             * price : 50.0
             */

            private String price;

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }
        }
    }
}
