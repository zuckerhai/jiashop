package com.hai.model;

import java.io.Serializable;
import java.util.Date;

public class Trades
  implements Serializable
{
  private String seller_nick;
  private String pic_path;
  private String payment;
  private Boolean seller_rate;
  private String post_fee;
  private String receiver_name;
  private String receiver_state;
  private String receiver_address;
  private String receiver_zip;
  private String receiver_mobile;
  private String receiver_phone;
  private Date consign_time;
  private String received_payment;
  private String receiver_country;
  private String receiver_town;
  private String order_tax_fee;
  private String shop_pick;
  private Number tid;
  private Number num;
  private Number num_iid;
  private String status;
  private String title;
  private String type;
  private String price;
  private String discount_fee;
  private String total_fee;
  private Date created;
  private Date pay_time;
  private Date modified;
  private Date end_time;
  private Number seller_flag;
  private String buyer_nick;
  private Boolean has_buyer_message;
  private String credit_card_fee;
  private String step_trade_status;
  private String step_paid_fee;
  private String mark_desc;
  private String shipping_type;
  private String adjust_fee;
  private String trade_from;
  private ServiceOrder[] service_orders;
  private Boolean buyer_rate;
  private String receiver_city;
  private String receiver_district;
  private String o2o;
  private String o2o_guide_id;
  private String o2o_shop_id;
  private String o2o_guide_name;
  private String o2o_shop_name;
  private String o2o_delivery;
  private Order[] orders;
  private String rx_audit_status;
  private Boolean post_gate_declare;
  private Boolean cross_bonded_declare;
  private String order_tax_promotion_fee;
  private String service_type;

  public String getSeller_nick()
  {
    return this.seller_nick;
  }
  public String getPic_path() {
    return this.pic_path;
  }
  public String getPayment() {
    return this.payment;
  }
  public Boolean getSeller_rate() {
    return this.seller_rate;
  }
  public String getPost_fee() {
    return this.post_fee;
  }
  public String getReceiver_name() {
    return this.receiver_name;
  }
  public String getReceiver_state() {
    return this.receiver_state;
  }
  public String getReceiver_address() {
    return this.receiver_address;
  }
  public String getReceiver_zip() {
    return this.receiver_zip;
  }
  public String getReceiver_mobile() {
    return this.receiver_mobile;
  }
  public String getReceiver_phone() {
    return this.receiver_phone;
  }
  public Date getConsign_time() {
    return this.consign_time;
  }
  public String getReceived_payment() {
    return this.received_payment;
  }
  public String getReceiver_country() {
    return this.receiver_country;
  }
  public String getReceiver_town() {
    return this.receiver_town;
  }
  public String getOrder_tax_fee() {
    return this.order_tax_fee;
  }
  public String getShop_pick() {
    return this.shop_pick;
  }
  public Number getTid() {
    return this.tid;
  }
  public Number getNum() {
    return this.num;
  }
  public Number getNum_iid() {
    return this.num_iid;
  }
  public String getStatus() {
    return this.status;
  }
  public String getTitle() {
    return this.title;
  }
  public String getType() {
    return this.type;
  }
  public String getPrice() {
    return this.price;
  }
  public String getDiscount_fee() {
    return this.discount_fee;
  }
  public String getTotal_fee() {
    return this.total_fee;
  }
  public Date getCreated() {
    return this.created;
  }
  public Date getPay_time() {
    return this.pay_time;
  }
  public Date getModified() {
    return this.modified;
  }
  public Date getEnd_time() {
    return this.end_time;
  }
  public Number getSeller_flag() {
    return this.seller_flag;
  }
  public String getBuyer_nick() {
    return this.buyer_nick;
  }
  public Boolean getHas_buyer_message() {
    return this.has_buyer_message;
  }
  public String getCredit_card_fee() {
    return this.credit_card_fee;
  }
  public String getStep_trade_status() {
    return this.step_trade_status;
  }
  public String getStep_paid_fee() {
    return this.step_paid_fee;
  }
  public String getMark_desc() {
    return this.mark_desc;
  }
  public String getShipping_type() {
    return this.shipping_type;
  }
  public String getAdjust_fee() {
    return this.adjust_fee;
  }
  public String getTrade_from() {
    return this.trade_from;
  }
  public ServiceOrder[] getService_orders() {
    return this.service_orders;
  }
  public Boolean getBuyer_rate() {
    return this.buyer_rate;
  }
  public String getReceiver_city() {
    return this.receiver_city;
  }
  public String getReceiver_district() {
    return this.receiver_district;
  }
  public String getO2o() {
    return this.o2o;
  }
  public String getO2o_guide_id() {
    return this.o2o_guide_id;
  }
  public String getO2o_shop_id() {
    return this.o2o_shop_id;
  }
  public String getO2o_guide_name() {
    return this.o2o_guide_name;
  }
  public String getO2o_shop_name() {
    return this.o2o_shop_name;
  }
  public String getO2o_delivery() {
    return this.o2o_delivery;
  }
  public Order[] getOrders() {
    return this.orders;
  }
  public String getRx_audit_status() {
    return this.rx_audit_status;
  }
  public Boolean getPost_gate_declare() {
    return this.post_gate_declare;
  }
  public Boolean getCross_bonded_declare() {
    return this.cross_bonded_declare;
  }
  public String getOrder_tax_promotion_fee() {
    return this.order_tax_promotion_fee;
  }
  public String getService_type() {
    return this.service_type;
  }
  public void setSeller_nick(String seller_nick) {
    this.seller_nick = seller_nick;
  }
  public void setPic_path(String pic_path) {
    this.pic_path = pic_path;
  }
  public void setPayment(String payment) {
    this.payment = payment;
  }
  public void setSeller_rate(Boolean seller_rate) {
    this.seller_rate = seller_rate;
  }
  public void setPost_fee(String post_fee) {
    this.post_fee = post_fee;
  }
  public void setReceiver_name(String receiver_name) {
    this.receiver_name = receiver_name;
  }
  public void setReceiver_state(String receiver_state) {
    this.receiver_state = receiver_state;
  }
  public void setReceiver_address(String receiver_address) {
    this.receiver_address = receiver_address;
  }
  public void setReceiver_zip(String receiver_zip) {
    this.receiver_zip = receiver_zip;
  }
  public void setReceiver_mobile(String receiver_mobile) {
    this.receiver_mobile = receiver_mobile;
  }
  public void setReceiver_phone(String receiver_phone) {
    this.receiver_phone = receiver_phone;
  }
  public void setConsign_time(Date consign_time) {
    this.consign_time = consign_time;
  }
  public void setReceived_payment(String received_payment) {
    this.received_payment = received_payment;
  }
  public void setReceiver_country(String receiver_country) {
    this.receiver_country = receiver_country;
  }
  public void setReceiver_town(String receiver_town) {
    this.receiver_town = receiver_town;
  }
  public void setOrder_tax_fee(String order_tax_fee) {
    this.order_tax_fee = order_tax_fee;
  }
  public void setShop_pick(String shop_pick) {
    this.shop_pick = shop_pick;
  }
  public void setTid(Number tid) {
    this.tid = tid;
  }
  public void setNum(Number num) {
    this.num = num;
  }
  public void setNum_iid(Number num_iid) {
    this.num_iid = num_iid;
  }
  public void setStatus(String status) {
    this.status = status;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public void setType(String type) {
    this.type = type;
  }
  public void setPrice(String price) {
    this.price = price;
  }
  public void setDiscount_fee(String discount_fee) {
    this.discount_fee = discount_fee;
  }
  public void setTotal_fee(String total_fee) {
    this.total_fee = total_fee;
  }
  public void setCreated(Date created) {
    this.created = created;
  }
  public void setPay_time(Date pay_time) {
    this.pay_time = pay_time;
  }
  public void setModified(Date modified) {
    this.modified = modified;
  }
  public void setEnd_time(Date end_time) {
    this.end_time = end_time;
  }
  public void setSeller_flag(Number seller_flag) {
    this.seller_flag = seller_flag;
  }
  public void setBuyer_nick(String buyer_nick) {
    this.buyer_nick = buyer_nick;
  }
  public void setHas_buyer_message(Boolean has_buyer_message) {
    this.has_buyer_message = has_buyer_message;
  }
  public void setCredit_card_fee(String credit_card_fee) {
    this.credit_card_fee = credit_card_fee;
  }
  public void setStep_trade_status(String step_trade_status) {
    this.step_trade_status = step_trade_status;
  }
  public void setStep_paid_fee(String step_paid_fee) {
    this.step_paid_fee = step_paid_fee;
  }
  public void setMark_desc(String mark_desc) {
    this.mark_desc = mark_desc;
  }
  public void setShipping_type(String shipping_type) {
    this.shipping_type = shipping_type;
  }
  public void setAdjust_fee(String adjust_fee) {
    this.adjust_fee = adjust_fee;
  }
  public void setTrade_from(String trade_from) {
    this.trade_from = trade_from;
  }
  public void setService_orders(ServiceOrder[] service_orders) {
    this.service_orders = service_orders;
  }
  public void setBuyer_rate(Boolean buyer_rate) {
    this.buyer_rate = buyer_rate;
  }
  public void setReceiver_city(String receiver_city) {
    this.receiver_city = receiver_city;
  }
  public void setReceiver_district(String receiver_district) {
    this.receiver_district = receiver_district;
  }
  public void setO2o(String o2o) {
    this.o2o = o2o;
  }
  public void setO2o_guide_id(String o2o_guide_id) {
    this.o2o_guide_id = o2o_guide_id;
  }
  public void setO2o_shop_id(String o2o_shop_id) {
    this.o2o_shop_id = o2o_shop_id;
  }
  public void setO2o_guide_name(String o2o_guide_name) {
    this.o2o_guide_name = o2o_guide_name;
  }
  public void setO2o_shop_name(String o2o_shop_name) {
    this.o2o_shop_name = o2o_shop_name;
  }
  public void setO2o_delivery(String o2o_delivery) {
    this.o2o_delivery = o2o_delivery;
  }
  public void setOrders(Order[] orders) {
    this.orders = orders;
  }
  public void setRx_audit_status(String rx_audit_status) {
    this.rx_audit_status = rx_audit_status;
  }
  public void setPost_gate_declare(Boolean post_gate_declare) {
    this.post_gate_declare = post_gate_declare;
  }
  public void setCross_bonded_declare(Boolean cross_bonded_declare) {
    this.cross_bonded_declare = cross_bonded_declare;
  }
  public void setOrder_tax_promotion_fee(String order_tax_promotion_fee) {
    this.order_tax_promotion_fee = order_tax_promotion_fee;
  }
  public void setService_type(String service_type) {
    this.service_type = service_type;
  }
}