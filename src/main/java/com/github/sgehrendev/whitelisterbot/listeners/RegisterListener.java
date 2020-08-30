package com.github.sgehrendev.whitelisterbot.listeners;

import com.github.sgehrendev.whitelisterbot.core.Member;

import java.util.ArrayList;
import java.util.List;

/**
 * Listener register class
 */
public class RegisterListener {
    List<Listener> listeners = new ArrayList<>();

    public void addListener (Listener l) {
        listeners.add(l);
    }

    public List<Listener> getListeners() { return this.listeners; }

    public void callWhitelistListener(Member member, String s) {
        for(Listener listener : listeners) {
            if(listener instanceof WhitelistListener) {
                ((WhitelistListener) listener).onWhitelistCommand(member, s);
            }
        }
    }

    public void callBanListener(Member member) {
        for(Listener listener : listeners) {
            if(listener instanceof BanListener) {
                ((BanListener) listener).onBanCommand(member);
            }
        }
    }
}
