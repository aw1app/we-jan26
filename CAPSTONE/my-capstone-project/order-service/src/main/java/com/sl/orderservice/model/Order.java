package com.sl.orderservice.model;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "user_id")
    private String userId;

    private String name;
    private String contact;
    private String email;
    private String address;

    @Column(name = "items_sub_total")
    private double itemsSubTotal;

    @Column(name = "shipment_charges")
    private double shipmentCharges;

    @Column(name = "total_amount")
    private double totalAmount;

    @Column(name = "total_items")
    private int totalItems;

    @Column(name = "order_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "payment_status")
    private String paymentStatus;

    @Transient
    private List<OrderItem> orderItems;

    public Order() {}

    public Order(Long orderId, String userId, String name, String contact, String email, String address, double itemsSubTotal, double shipmentCharges, double totalAmount, int totalItems, Date orderDate, String orderStatus, String paymentMethod, String paymentStatus) {
        this.orderId = orderId;
        this.userId = userId;
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.itemsSubTotal = itemsSubTotal;
        this.shipmentCharges = shipmentCharges;
        this.totalAmount = totalAmount;
        this.totalItems = totalItems;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public double getItemsSubTotal() { return itemsSubTotal; }
    public void setItemsSubTotal(double itemsSubTotal) { this.itemsSubTotal = itemsSubTotal; }

    public double getShipmentCharges() { return shipmentCharges; }
    public void setShipmentCharges(double shipmentCharges) { this.shipmentCharges = shipmentCharges; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public int getTotalItems() { return totalItems; }
    public void setTotalItems(int totalItems) { this.totalItems = totalItems; }

    public Date getOrderDate() { return orderDate; }
    public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }

    public String getOrderStatus() { return orderStatus; }
    public void setOrderStatus(String orderStatus) { this.orderStatus = orderStatus; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }

    public List<OrderItem> getOrderItems() { return orderItems; }
    public void setOrderItems(List<OrderItem> orderItems) { this.orderItems = orderItems; }
}

