package com.github.sgehrendev.whitelisterbot.listeners;

import com.github.sgehrendev.whitelisterbot.core.Member;

import java.util.List;

public interface BanListener extends Listener {
    void onBanCommand(Member member);
}
