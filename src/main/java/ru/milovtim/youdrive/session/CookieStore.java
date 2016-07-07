package ru.milovtim.youdrive.session;

import com.google.common.collect.Sets;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Set;

/**
 * Created on 07.07.16.
 */
@Component
public class CookieStore implements Iterable<String> {
    private final Set<String> cookies = Sets.newConcurrentHashSet();

    @Override
    public Iterator<String> iterator() {
        return cookies.iterator();
    }

    public void addCookie(String cookie) {
        cookies.add(cookie);
    }
}
