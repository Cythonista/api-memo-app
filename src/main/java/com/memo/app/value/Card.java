package com.memo.app.value;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Card {
    private final Long cardId;
    private final String cardName;
    private final String overview;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private final LocalDateTime insertTime;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private final LocalDateTime updatedTime;
    private final Boolean deleteFlag;

    public Card(Long cardId, String cardName, String overview, LocalDateTime insertTime, LocalDateTime updatedTime, Boolean deleteFlag) {
        this.cardId = cardId;
        this.cardName = cardName;
        this.overview = overview;
        this.insertTime = insertTime;
        this.updatedTime = updatedTime;
        this.deleteFlag = deleteFlag;
    }

    public Long getCardId() {
        return cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public String getOverview() {
        return overview;
    }

    public LocalDateTime getInsertTime() {
        return insertTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

}
