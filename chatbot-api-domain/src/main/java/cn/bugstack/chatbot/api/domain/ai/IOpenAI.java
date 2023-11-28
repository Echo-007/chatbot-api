package cn.bugstack.chatbot.api.domain.ai;

import java.io.IOException;

/**
 * ChatGPT OpenAi接口
 */
public interface IOpenAI {
    String doChatGPT(String question) throws IOException;


}
