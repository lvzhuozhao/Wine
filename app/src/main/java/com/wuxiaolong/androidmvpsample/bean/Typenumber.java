package com.wuxiaolong.androidmvpsample.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by LZZ on 2017/8/28.
 */

public class Typenumber {

    /**
     * jsonInfo : {"code":"0","data":{"1号楼":"10","2号楼":"10","3号楼":"10","水上木屋":"0","别墅":"0"},"msg":"成功"}
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
         * data : {"1号楼":"10","2号楼":"10","3号楼":"10","水上木屋":"0","别墅":"0"}
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
             * 1号楼 : 10
             * 2号楼 : 10
             * 3号楼 : 10
             * 水上木屋 : 0
             * 别墅 : 0
             */

            @SerializedName("1号楼")
            private String _$1号楼;
            @SerializedName("2号楼")
            private String _$2号楼;
            @SerializedName("3号楼")
            private String _$3号楼;
            private String 水上木屋;
            private String 别墅;

            public String get_$1号楼() {
                return _$1号楼;
            }

            public void set_$1号楼(String _$1号楼) {
                this._$1号楼 = _$1号楼;
            }

            public String get_$2号楼() {
                return _$2号楼;
            }

            public void set_$2号楼(String _$2号楼) {
                this._$2号楼 = _$2号楼;
            }

            public String get_$3号楼() {
                return _$3号楼;
            }

            public void set_$3号楼(String _$3号楼) {
                this._$3号楼 = _$3号楼;
            }

            public String get水上木屋() {
                return 水上木屋;
            }

            public void set水上木屋(String 水上木屋) {
                this.水上木屋 = 水上木屋;
            }

            public String get别墅() {
                return 别墅;
            }

            public void set别墅(String 别墅) {
                this.别墅 = 别墅;
            }
        }
    }
}
