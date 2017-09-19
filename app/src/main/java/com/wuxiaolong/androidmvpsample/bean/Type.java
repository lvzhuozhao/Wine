package com.wuxiaolong.androidmvpsample.bean;

import java.util.List;

/**
 * Created by LZZ on 2017/8/28.
 */

public class Type {

    /**
     * jsonInfo : {"code":"0","data":[{"id":1,"roomTypeName":"普通标间"},{"id":2,"roomTypeName":"豪华标间"},{"id":3,"roomTypeName":"普通大床"},{"id":4,"roomTypeName":"豪华大床"},{"id":5,"roomTypeName":"别墅"},{"id":6,"roomTypeName":"水上木屋"}],"msg":"成功"}
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
         * data : [{"id":1,"roomTypeName":"普通标间"},{"id":2,"roomTypeName":"豪华标间"},{"id":3,"roomTypeName":"普通大床"},{"id":4,"roomTypeName":"豪华大床"},{"id":5,"roomTypeName":"别墅"},{"id":6,"roomTypeName":"水上木屋"}]
         * msg : 成功
         */

        private String code;
        private String msg;
        private List<DataBean> data;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * id : 1
             * roomTypeName : 普通标间
             */

            private int id;
            private String roomTypeName;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getRoomTypeName() {
                return roomTypeName;
            }

            public void setRoomTypeName(String roomTypeName) {
                this.roomTypeName = roomTypeName;
            }
        }
    }
}
