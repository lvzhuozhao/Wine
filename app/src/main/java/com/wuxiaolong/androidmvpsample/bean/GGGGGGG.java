package com.wuxiaolong.androidmvpsample.bean;

import java.util.List;

/**
 * Created by LZZ on 2017/8/31.
 */

public class GGGGGGG {

    /**
     * jsonInfo : {"code":"0","data":{"day":"0","roomOrder":{"checkInDate":"2017-08-31 00:00:00","checkOutDate":"2017-09-01 00:00:00","count":"1","department":"客房部","guestCount":"0","guestName":"王二","guestPhone":"18501176671","guestRemarks":"0708","guestSource":"散客","market":"南昌","oid":"78","orderNumber":"KF1504155304497","orderStatus":"已预定","orderSum":"","oweMoneyType":"第三方","reserveDate":"2017-08-31 12:55:04","reserveType":"普通标间","reserveUser":"room","roomType":"普通标间","sum":"￥100.0"},"restaurantOrder":[{"checkInDate":"2017-09-29 00:00:00","checkOutDate":"--","count":"1","department":"客房部","guestCount":"5","guestName":"王二","guestPhone":"124","guestRemarks":"0506","guestSource":"散客","market":"南昌","oid":"79","orderNumber":"KF1504155393498","orderStatus":"已完成","orderSum":"","oweMoneyType":"","reserveDate":"2017-08-31 12:56:33","reserveType":"包厢","reserveUser":"room","roomType":"--","sum":"￥300.0"},{"checkInDate":"2017-09-29 00:00:00","checkOutDate":"--","count":"1","department":"客房部","guestCount":"5","guestName":"王","guestPhone":"18501176671","guestRemarks":"0708","guestSource":"散客","market":"南昌","oid":"76","orderNumber":"KF1504155243203","orderStatus":"已完成","orderSum":"","oweMoneyType":"","reserveDate":"2017-08-31 12:54:03","reserveType":"包厢","reserveUser":"room","roomType":"--","sum":"￥100.0"}],"hotSpringOrder":[{"checkInDate":"2017-09-28 00:00:00","checkOutDate":"--","count":"1","department":"客房部","guestCount":"0","guestName":"王二","guestPhone":"124","guestRemarks":"0203","guestSource":"散客","market":"南昌","oid":"80","orderNumber":"KF1504155393596","orderStatus":"已完成","orderSum":"","oweMoneyType":"","reserveDate":"2017-08-31 12:56:33","reserveType":"一般","reserveUser":"room","roomType":"--","sum":"￥100.0"}]},"msg":"成功"}
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
         * data : {"day":"0","roomOrder":{"checkInDate":"2017-08-31 00:00:00","checkOutDate":"2017-09-01 00:00:00","count":"1","department":"客房部","guestCount":"0","guestName":"王二","guestPhone":"18501176671","guestRemarks":"0708","guestSource":"散客","market":"南昌","oid":"78","orderNumber":"KF1504155304497","orderStatus":"已预定","orderSum":"","oweMoneyType":"第三方","reserveDate":"2017-08-31 12:55:04","reserveType":"普通标间","reserveUser":"room","roomType":"普通标间","sum":"￥100.0"},"restaurantOrder":[{"checkInDate":"2017-09-29 00:00:00","checkOutDate":"--","count":"1","department":"客房部","guestCount":"5","guestName":"王二","guestPhone":"124","guestRemarks":"0506","guestSource":"散客","market":"南昌","oid":"79","orderNumber":"KF1504155393498","orderStatus":"已完成","orderSum":"","oweMoneyType":"","reserveDate":"2017-08-31 12:56:33","reserveType":"包厢","reserveUser":"room","roomType":"--","sum":"￥300.0"},{"checkInDate":"2017-09-29 00:00:00","checkOutDate":"--","count":"1","department":"客房部","guestCount":"5","guestName":"王","guestPhone":"18501176671","guestRemarks":"0708","guestSource":"散客","market":"南昌","oid":"76","orderNumber":"KF1504155243203","orderStatus":"已完成","orderSum":"","oweMoneyType":"","reserveDate":"2017-08-31 12:54:03","reserveType":"包厢","reserveUser":"room","roomType":"--","sum":"￥100.0"}],"hotSpringOrder":[{"checkInDate":"2017-09-28 00:00:00","checkOutDate":"--","count":"1","department":"客房部","guestCount":"0","guestName":"王二","guestPhone":"124","guestRemarks":"0203","guestSource":"散客","market":"南昌","oid":"80","orderNumber":"KF1504155393596","orderStatus":"已完成","orderSum":"","oweMoneyType":"","reserveDate":"2017-08-31 12:56:33","reserveType":"一般","reserveUser":"room","roomType":"--","sum":"￥100.0"}]}
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
             * roomOrder : {"checkInDate":"2017-08-31 00:00:00","checkOutDate":"2017-09-01 00:00:00","count":"1","department":"客房部","guestCount":"0","guestName":"王二","guestPhone":"18501176671","guestRemarks":"0708","guestSource":"散客","market":"南昌","oid":"78","orderNumber":"KF1504155304497","orderStatus":"已预定","orderSum":"","oweMoneyType":"第三方","reserveDate":"2017-08-31 12:55:04","reserveType":"普通标间","reserveUser":"room","roomType":"普通标间","sum":"￥100.0"}
             * restaurantOrder : [{"checkInDate":"2017-09-29 00:00:00","checkOutDate":"--","count":"1","department":"客房部","guestCount":"5","guestName":"王二","guestPhone":"124","guestRemarks":"0506","guestSource":"散客","market":"南昌","oid":"79","orderNumber":"KF1504155393498","orderStatus":"已完成","orderSum":"","oweMoneyType":"","reserveDate":"2017-08-31 12:56:33","reserveType":"包厢","reserveUser":"room","roomType":"--","sum":"￥300.0"},{"checkInDate":"2017-09-29 00:00:00","checkOutDate":"--","count":"1","department":"客房部","guestCount":"5","guestName":"王","guestPhone":"18501176671","guestRemarks":"0708","guestSource":"散客","market":"南昌","oid":"76","orderNumber":"KF1504155243203","orderStatus":"已完成","orderSum":"","oweMoneyType":"","reserveDate":"2017-08-31 12:54:03","reserveType":"包厢","reserveUser":"room","roomType":"--","sum":"￥100.0"}]
             * hotSpringOrder : [{"checkInDate":"2017-09-28 00:00:00","checkOutDate":"--","count":"1","department":"客房部","guestCount":"0","guestName":"王二","guestPhone":"124","guestRemarks":"0203","guestSource":"散客","market":"南昌","oid":"80","orderNumber":"KF1504155393596","orderStatus":"已完成","orderSum":"","oweMoneyType":"","reserveDate":"2017-08-31 12:56:33","reserveType":"一般","reserveUser":"room","roomType":"--","sum":"￥100.0"}]
             */
            private String day;
            private RoomOrderBean roomOrder;
            private List<RestaurantOrderBean> restaurantOrder;
            private List<HotSpringOrderBean> hotSpringOrder;
            public String getDay() {
                return day;
            }

            public void setDay(String day) {
                this.day = day;
            }
            public RoomOrderBean getRoomOrder() {
                return roomOrder;
            }

            public void setRoomOrder(RoomOrderBean roomOrder) {
                this.roomOrder = roomOrder;
            }

            public List<RestaurantOrderBean> getRestaurantOrder() {
                return restaurantOrder;
            }

            public void setRestaurantOrder(List<RestaurantOrderBean> restaurantOrder) {
                this.restaurantOrder = restaurantOrder;
            }

            public List<HotSpringOrderBean> getHotSpringOrder() {
                return hotSpringOrder;
            }

            public void setHotSpringOrder(List<HotSpringOrderBean> hotSpringOrder) {
                this.hotSpringOrder = hotSpringOrder;
            }

            public static class RoomOrderBean {
                /**
                 * checkInDate : 2017-08-31 00:00:00
                 * checkOutDate : 2017-09-01 00:00:00
                 * count : 1
                 * department : 客房部
                 * guestCount : 0
                 * guestName : 王二
                 * guestPhone : 18501176671
                 * guestRemarks : 0708
                 * guestSource : 散客
                 * market : 南昌
                 * oid : 78
                 * orderNumber : KF1504155304497
                 * orderStatus : 已预定
                 * orderSum :
                 * oweMoneyType : 第三方
                 * reserveDate : 2017-08-31 12:55:04
                 * reserveType : 普通标间
                 * reserveUser : room
                 * roomType : 普通标间
                 * sum : ￥100.0
                 */

                private String checkInDate;
                private String checkOutDate;
                private String count;
                private String department;
                private String guestCount;
                private String guestName;
                private String guestPhone;
                private String guestRemarks;
                private String guestSource;
                private String market;
                private String oid;
                private String orderNumber;
                private String orderStatus;
                private String orderSum;
                private String oweMoneyType;
                private String reserveDate;
                private String reserveType;
                private String reserveUser;
                private String roomType;
                private String sum;

                public String getCheckInDate() {
                    return checkInDate;
                }

                public void setCheckInDate(String checkInDate) {
                    this.checkInDate = checkInDate;
                }

                public String getCheckOutDate() {
                    return checkOutDate;
                }

                public void setCheckOutDate(String checkOutDate) {
                    this.checkOutDate = checkOutDate;
                }

                public String getCount() {
                    return count;
                }

                public void setCount(String count) {
                    this.count = count;
                }

                public String getDepartment() {
                    return department;
                }

                public void setDepartment(String department) {
                    this.department = department;
                }

                public String getGuestCount() {
                    return guestCount;
                }

                public void setGuestCount(String guestCount) {
                    this.guestCount = guestCount;
                }

                public String getGuestName() {
                    return guestName;
                }

                public void setGuestName(String guestName) {
                    this.guestName = guestName;
                }

                public String getGuestPhone() {
                    return guestPhone;
                }

                public void setGuestPhone(String guestPhone) {
                    this.guestPhone = guestPhone;
                }

                public String getGuestRemarks() {
                    return guestRemarks;
                }

                public void setGuestRemarks(String guestRemarks) {
                    this.guestRemarks = guestRemarks;
                }

                public String getGuestSource() {
                    return guestSource;
                }

                public void setGuestSource(String guestSource) {
                    this.guestSource = guestSource;
                }

                public String getMarket() {
                    return market;
                }

                public void setMarket(String market) {
                    this.market = market;
                }

                public String getOid() {
                    return oid;
                }

                public void setOid(String oid) {
                    this.oid = oid;
                }

                public String getOrderNumber() {
                    return orderNumber;
                }

                public void setOrderNumber(String orderNumber) {
                    this.orderNumber = orderNumber;
                }

                public String getOrderStatus() {
                    return orderStatus;
                }

                public void setOrderStatus(String orderStatus) {
                    this.orderStatus = orderStatus;
                }

                public String getOrderSum() {
                    return orderSum;
                }

                public void setOrderSum(String orderSum) {
                    this.orderSum = orderSum;
                }

                public String getOweMoneyType() {
                    return oweMoneyType;
                }

                public void setOweMoneyType(String oweMoneyType) {
                    this.oweMoneyType = oweMoneyType;
                }

                public String getReserveDate() {
                    return reserveDate;
                }

                public void setReserveDate(String reserveDate) {
                    this.reserveDate = reserveDate;
                }

                public String getReserveType() {
                    return reserveType;
                }

                public void setReserveType(String reserveType) {
                    this.reserveType = reserveType;
                }

                public String getReserveUser() {
                    return reserveUser;
                }

                public void setReserveUser(String reserveUser) {
                    this.reserveUser = reserveUser;
                }

                public String getRoomType() {
                    return roomType;
                }

                public void setRoomType(String roomType) {
                    this.roomType = roomType;
                }

                public String getSum() {
                    return sum;
                }

                public void setSum(String sum) {
                    this.sum = sum;
                }
            }

            public static class RestaurantOrderBean {
                /**
                 * checkInDate : 2017-09-29 00:00:00
                 * checkOutDate : --
                 * count : 1
                 * department : 客房部
                 * guestCount : 5
                 * guestName : 王二
                 * guestPhone : 124
                 * guestRemarks : 0506
                 * guestSource : 散客
                 * market : 南昌
                 * oid : 79
                 * orderNumber : KF1504155393498
                 * orderStatus : 已完成
                 * orderSum :
                 * oweMoneyType :
                 * reserveDate : 2017-08-31 12:56:33
                 * reserveType : 包厢
                 * reserveUser : room
                 * roomType : --
                 * sum : ￥300.0
                 */

                private String checkInDate;
                private String checkOutDate;
                private String count;
                private String department;
                private String guestCount;
                private String guestName;
                private String guestPhone;
                private String guestRemarks;
                private String guestSource;
                private String market;
                private String oid;
                private String orderNumber;
                private String orderStatus;
                private String orderSum;
                private String oweMoneyType;
                private String reserveDate;
                private String reserveType;
                private String reserveUser;
                private String roomType;
                private String sum;

                public String getCheckInDate() {
                    return checkInDate;
                }

                public void setCheckInDate(String checkInDate) {
                    this.checkInDate = checkInDate;
                }

                public String getCheckOutDate() {
                    return checkOutDate;
                }

                public void setCheckOutDate(String checkOutDate) {
                    this.checkOutDate = checkOutDate;
                }

                public String getCount() {
                    return count;
                }

                public void setCount(String count) {
                    this.count = count;
                }

                public String getDepartment() {
                    return department;
                }

                public void setDepartment(String department) {
                    this.department = department;
                }

                public String getGuestCount() {
                    return guestCount;
                }

                public void setGuestCount(String guestCount) {
                    this.guestCount = guestCount;
                }

                public String getGuestName() {
                    return guestName;
                }

                public void setGuestName(String guestName) {
                    this.guestName = guestName;
                }

                public String getGuestPhone() {
                    return guestPhone;
                }

                public void setGuestPhone(String guestPhone) {
                    this.guestPhone = guestPhone;
                }

                public String getGuestRemarks() {
                    return guestRemarks;
                }

                public void setGuestRemarks(String guestRemarks) {
                    this.guestRemarks = guestRemarks;
                }

                public String getGuestSource() {
                    return guestSource;
                }

                public void setGuestSource(String guestSource) {
                    this.guestSource = guestSource;
                }

                public String getMarket() {
                    return market;
                }

                public void setMarket(String market) {
                    this.market = market;
                }

                public String getOid() {
                    return oid;
                }

                public void setOid(String oid) {
                    this.oid = oid;
                }

                public String getOrderNumber() {
                    return orderNumber;
                }

                public void setOrderNumber(String orderNumber) {
                    this.orderNumber = orderNumber;
                }

                public String getOrderStatus() {
                    return orderStatus;
                }

                public void setOrderStatus(String orderStatus) {
                    this.orderStatus = orderStatus;
                }

                public String getOrderSum() {
                    return orderSum;
                }

                public void setOrderSum(String orderSum) {
                    this.orderSum = orderSum;
                }

                public String getOweMoneyType() {
                    return oweMoneyType;
                }

                public void setOweMoneyType(String oweMoneyType) {
                    this.oweMoneyType = oweMoneyType;
                }

                public String getReserveDate() {
                    return reserveDate;
                }

                public void setReserveDate(String reserveDate) {
                    this.reserveDate = reserveDate;
                }

                public String getReserveType() {
                    return reserveType;
                }

                public void setReserveType(String reserveType) {
                    this.reserveType = reserveType;
                }

                public String getReserveUser() {
                    return reserveUser;
                }

                public void setReserveUser(String reserveUser) {
                    this.reserveUser = reserveUser;
                }

                public String getRoomType() {
                    return roomType;
                }

                public void setRoomType(String roomType) {
                    this.roomType = roomType;
                }

                public String getSum() {
                    return sum;
                }

                public void setSum(String sum) {
                    this.sum = sum;
                }
            }

            public static class HotSpringOrderBean {
                /**
                 * checkInDate : 2017-09-28 00:00:00
                 * checkOutDate : --
                 * count : 1
                 * department : 客房部
                 * guestCount : 0
                 * guestName : 王二
                 * guestPhone : 124
                 * guestRemarks : 0203
                 * guestSource : 散客
                 * market : 南昌
                 * oid : 80
                 * orderNumber : KF1504155393596
                 * orderStatus : 已完成
                 * orderSum :
                 * oweMoneyType :
                 * reserveDate : 2017-08-31 12:56:33
                 * reserveType : 一般
                 * reserveUser : room
                 * roomType : --
                 * sum : ￥100.0
                 */

                private String checkInDate;
                private String checkOutDate;
                private String count;
                private String department;
                private String guestCount;
                private String guestName;
                private String guestPhone;
                private String guestRemarks;
                private String guestSource;
                private String market;
                private String oid;
                private String orderNumber;
                private String orderStatus;
                private String orderSum;
                private String oweMoneyType;
                private String reserveDate;
                private String reserveType;
                private String reserveUser;
                private String roomType;
                private String sum;

                public String getCheckInDate() {
                    return checkInDate;
                }

                public void setCheckInDate(String checkInDate) {
                    this.checkInDate = checkInDate;
                }

                public String getCheckOutDate() {
                    return checkOutDate;
                }

                public void setCheckOutDate(String checkOutDate) {
                    this.checkOutDate = checkOutDate;
                }

                public String getCount() {
                    return count;
                }

                public void setCount(String count) {
                    this.count = count;
                }

                public String getDepartment() {
                    return department;
                }

                public void setDepartment(String department) {
                    this.department = department;
                }

                public String getGuestCount() {
                    return guestCount;
                }

                public void setGuestCount(String guestCount) {
                    this.guestCount = guestCount;
                }

                public String getGuestName() {
                    return guestName;
                }

                public void setGuestName(String guestName) {
                    this.guestName = guestName;
                }

                public String getGuestPhone() {
                    return guestPhone;
                }

                public void setGuestPhone(String guestPhone) {
                    this.guestPhone = guestPhone;
                }

                public String getGuestRemarks() {
                    return guestRemarks;
                }

                public void setGuestRemarks(String guestRemarks) {
                    this.guestRemarks = guestRemarks;
                }

                public String getGuestSource() {
                    return guestSource;
                }

                public void setGuestSource(String guestSource) {
                    this.guestSource = guestSource;
                }

                public String getMarket() {
                    return market;
                }

                public void setMarket(String market) {
                    this.market = market;
                }

                public String getOid() {
                    return oid;
                }

                public void setOid(String oid) {
                    this.oid = oid;
                }

                public String getOrderNumber() {
                    return orderNumber;
                }

                public void setOrderNumber(String orderNumber) {
                    this.orderNumber = orderNumber;
                }

                public String getOrderStatus() {
                    return orderStatus;
                }

                public void setOrderStatus(String orderStatus) {
                    this.orderStatus = orderStatus;
                }

                public String getOrderSum() {
                    return orderSum;
                }

                public void setOrderSum(String orderSum) {
                    this.orderSum = orderSum;
                }

                public String getOweMoneyType() {
                    return oweMoneyType;
                }

                public void setOweMoneyType(String oweMoneyType) {
                    this.oweMoneyType = oweMoneyType;
                }

                public String getReserveDate() {
                    return reserveDate;
                }

                public void setReserveDate(String reserveDate) {
                    this.reserveDate = reserveDate;
                }

                public String getReserveType() {
                    return reserveType;
                }

                public void setReserveType(String reserveType) {
                    this.reserveType = reserveType;
                }

                public String getReserveUser() {
                    return reserveUser;
                }

                public void setReserveUser(String reserveUser) {
                    this.reserveUser = reserveUser;
                }

                public String getRoomType() {
                    return roomType;
                }

                public void setRoomType(String roomType) {
                    this.roomType = roomType;
                }

                public String getSum() {
                    return sum;
                }

                public void setSum(String sum) {
                    this.sum = sum;
                }
            }
        }
    }
}
