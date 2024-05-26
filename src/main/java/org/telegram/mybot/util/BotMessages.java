package org.telegram.mybot.util;

public class BotMessages {

    public static final String START_MESSAGE =
            """
            🤖 GitHub Notification Bot

            Welcome to the GitHub Notification Bot!
            Stay up-to-date with the latest activity on your GitHub repositories right in your Telegram chat.
            
            🔔 Repository Updates
            Receive instant notifications for new commits, pull requests, issues, and more directly from your GitHub repositories. Never miss an important update again!
            
            🔗 Quick Links
            Use the /link command to quickly access your GitHub repositories.
            
            Happy coding! 🚀
            """;

    public static final String HELP_MESSAGE =
            """
            🤖 GitHub Notification Bot Help
            
            Welcome to the GitHub Notification Bot! Below is a list of available commands along with their descriptions:
            
            /help
            /add
            """;

    public static final String DEFAULT_MESSAGE =
            """
            I'm sorry, but I didn't understand that command 😔
            """;

    public static final String ADD_MESSAGE_1 =
            """
            🤖 To add a webhook for your repository please write short name for it
            """;

    public static final String ADD_MESSAGE_2 =
            """
            To connect your repo add follow this instruction
            
            1. On GitHub.com, navigate to the main page of the repository.
            
            2. Under your repository name, click  ⚙️ Settings.
            
            3. In the left sidebar, click Webhooks.
            
            4. Click Add webhook.
            
            5. Under "Payload URL", type this URL: 🔗 {}
            
            6. Select application/json data format to receive the webhook payload in.
            
            7. Under "Which events would you like to trigger this webhook?", select the webhook events that you want to receive.
            
            8. To make the webhook active immediately after adding the configuration, select Active.
            
            9. Click Add webhook.
            
            To confirm
            """;

    public static final String INCORRECT_NAME_MESSAGE = """
            Invalid repository name. Repository name can only contain alphanumeric characters, hyphens, and underscores, and must be between 1 and 100 characters in length.
            """;

    public static final String EXCEPTION_ILLEGAL_ARGUMENT = "Illegal argument";
    public static final String EXCEPTION_RUNTIME_EXCEPTION = "Exception";

}
