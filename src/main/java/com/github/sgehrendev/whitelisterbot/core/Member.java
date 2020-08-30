package com.github.sgehrendev.whitelisterbot.core;

public class Member {
    String discordName, minecraftUsername, role;

    /**
     * Default constructor for Member
     */
    public Member() {}

    /**
     * Default constructor for Member
     * @param discordName Members discord username
     */
    public Member(String discordName) {
        this.discordName = discordName;
    }

    /**
     * Default constructor for Member
     * @param discordName Members discord username
     * @param minecraftUsername Members minecraft username
     */
    public Member(String discordName, String minecraftUsername) {
        this.discordName = discordName;
        this.minecraftUsername = minecraftUsername;
    }

    /**
     * Default constructor for Member
     * @param discordName Members discord username
     * @param minecraftUsername Members Minecraft Username
     * @param role Members discord role
     */
    public Member(String discordName, String minecraftUsername, String role) {
        this.discordName = discordName;
        this.minecraftUsername = minecraftUsername;
        this.role = role;
    }

    /**
     * Get the Members minecraft username
     * @return minecraftUsername
     */
    public String getDiscordName() { return this.discordName; }
    public String getMinecraftUsername() { return this.minecraftUsername; }
    public String getRole() { return this.role; }
}
