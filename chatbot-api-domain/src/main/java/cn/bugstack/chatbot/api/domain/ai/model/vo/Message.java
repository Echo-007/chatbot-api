package cn.bugstack.chatbot.api.domain.ai.model.vo;


/**
 * @author Hu.Sir
 * @date 2023-11-25
 */

public class Message {
    private String role;
    private String content;
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Message(String content) {
        this.role = "user";
        this.content = content;
    }
}

