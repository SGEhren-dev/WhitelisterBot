package com.github.sgehrendev.whitelisterbot.listeners;

import com.github.sgehrendev.whitelisterbot.core.Member;

/**
 * Interface for the WhitelistCommand Listener
 */
public interface WhitelistListener extends Listener {
    void onWhitelistCommand(Member member, String s);
}
