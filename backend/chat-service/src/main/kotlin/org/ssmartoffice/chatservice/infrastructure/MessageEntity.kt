package org.ssmartoffice.chatservice.infrastructure

import jakarta.persistence.*
import org.ssmartoffice.chatservice.domain.Message
import org.ssmartoffice.chatservice.domain.MessageType
import java.time.LocalDateTime

@Entity
@Table(name = "messages")
class MessageEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id :Long? = null,
    val userId :Long,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CHATROOM_ID")
    val chatroom :ChatroomEntity,
    @Enumerated(EnumType.STRING)
    val type : MessageType,
    val content :String,
    val deleted :Boolean = false,
    val createdAt : LocalDateTime = LocalDateTime.now(),
    val deletedAt : LocalDateTime = LocalDateTime.now()
) {

    companion object {
        fun fromModel(message: Message): MessageEntity {
            return MessageEntity(
                id = message.id,
                userId = message.userId,
                chatroom = ChatroomEntity.fromModel(message.chatroom),
                type = message.type,
                content = message.content,
                deleted = message.deleted,
                createdAt = message.createdAt,
                deletedAt = message.deletedAt
            )
        }
    }

    fun toModel() : Message {
        return Message(
            id = id!!,
            userId = userId,
            chatroom = chatroom.toModel(),
            type = type,
            content = content,
            deleted = deleted,
            createdAt = createdAt,
            deletedAt = deletedAt
        )
    }
}