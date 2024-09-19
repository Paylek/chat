package com.sviryd.chat.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sviryd.chat.domain.Message;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonPropertyOrder({"text", "authorID"})
public class CardDTO {

    private Long authorID;
    @JsonProperty("request")
    private String text;

    public static CardDTO toDTO(Message message) {
        CardDTOBuilder builder = CardDTO.builder();
        builder.text(message.getText());
        builder.authorID(message.getAuthorId());
        return builder.build();


    }
}
