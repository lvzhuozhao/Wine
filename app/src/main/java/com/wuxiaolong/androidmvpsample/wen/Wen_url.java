package com.wuxiaolong.androidmvpsample.wen;

/**
 * Created by LZZ on 2017/8/31.
 */

public class Wen_url {

    /**
     * jsonInfo : {"code":"0","data":{"url":"/hotels/order_detail.htm?recordId=11&orderType=hotspring&userName=spring"},"msg":"成功"}
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
         * data : {"url":"/hotels/order_detail.htm?recordId=11&orderType=hotspring&userName=spring"}
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
             * url : /hotels/order_detail.htm?recordId=11&orderType=hotspring&userName=spring
             */

            private String url;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
