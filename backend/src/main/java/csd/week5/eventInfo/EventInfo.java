package csd.week5.eventInfo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Lob;
import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import csd.week5.user.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class EventInfo {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    @NotBlank(message = "title date not be blank")
    @Lob
    @Column(columnDefinition = "TEXT")
    private String title;

    @NotBlank(message = "eventDetail should not be blank")
    @Lob
    @Column(columnDefinition = "TEXT")
    private String eventDetail;

    @NotBlank(message = "ticketPricing should not be blank")
    @Lob
    @Column(columnDefinition = "TEXT")
    private String ticketPricing;

    @NotBlank(message = "EnRPolicy should not be blank")
    @Lob
    @Column(columnDefinition = "TEXT")
    private String EnRPolicy;

    @NotBlank(message = "aPolicy should not be blank")
    @Lob
    @Column(columnDefinition = "TEXT")
    private String aPolicy;

    @NotBlank(message = "ticketInfo should not be blank")
    @Lob
    @Column(columnDefinition = "TEXT")
    private String ticketInfo;

    @NotBlank(message = "date should not be blank")
    @Lob
    @Column(columnDefinition = "TEXT")
    private String date;

    @Lob
    private byte[] image;

    public EventInfo(String title, String eventDetail,String date, String ticketPricing, String EnRPolicy, String aPolicy,
        String ticketInfo, byte[] image) {
        this.title = title;
        this.eventDetail = eventDetail;
        this.date = date;
        this.ticketPricing = ticketPricing;
        this.EnRPolicy = EnRPolicy;
        this.aPolicy = aPolicy;
        this.ticketInfo = ticketInfo;
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEventDetail(String eventDetail) {
        this.eventDetail = eventDetail;
    }

    public void setDate(String date){
        this.date = date;
    }

    public void setTicketPricing(String ticketPricing) {
        this.ticketPricing = ticketPricing;
    }

    public void setaPolicy(String aPolicy) {
        this.aPolicy = aPolicy;
    }

    public void setEnRPolicy(String EnRPolicy){
        this.EnRPolicy = EnRPolicy;
    }

    public void setTicketInfo(String ticketInfo) {
        this.ticketInfo = ticketInfo;
    }

    public void setImage(byte[] image){
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getEventDetail() {
        return eventDetail;
    }

    public String getDate(){
        return date;
    }

    public String getTicketPricing() {
        return ticketPricing;
    }

    public String getEnRPolicy() {
        return EnRPolicy;
    }

    public String getaPolicy() {
        return aPolicy;
    }

    public String getTicketInfo() {
        return ticketInfo;
    }

    public byte[] getImage(){
        return image;
    }

}