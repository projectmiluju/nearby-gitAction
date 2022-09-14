package com.hh99.nearby.chat.dto;

import com.hh99.nearby.chat.entity.ChatMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ChatMessageResponseDto {
    private ChatMessage.MessageType type;
    private String roomId;
    private String nickname;
    private String sender;
    private String message;
    private String createdAt;

    public ChatMessageResponseDto(ChatMessage chatMessage) {
        this.type = chatMessage.getType();
        this.roomId = chatMessage.getRoomId();
        this.nickname = chatMessage.getNickname();
        this.sender = chatMessage.getSender();
        this.message = chatMessage.getMessage();
        this.createdAt = chatMessage.getCreatedAt();
    }
}
