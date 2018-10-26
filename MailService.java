package Homework;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Messages<T>> {


    private static class MyHashMap<V, K> extends HashMap<V, K> {
        @Override
        public K get(Object key) {
            K temp = (K) super.get(key);
            try {
                if (temp == null) temp = (K) Collections.emptyList();
            } catch (ClassCastException e) {}
            return temp;

        }
    }
    private Map<String, List<T>> mailBox;
    public MailService() {
        mailBox = new MyHashMap<>();
    }
    @Override
    public void accept(Messages<T> t) {
        if(mailBox.containsKey(t.getTo())){
            List<T> val;
            val = mailBox.get(t.getTo());
            val.add(t.getContent());
            mailBox.put(t.getTo(), val);

        }else {
            List<T> val;
            val = new LinkedList<>();
            val.add(t.getContent());
            mailBox.put(t.getTo(),val);
        }
    }

    public Map<String, List<T>> getMailBox(){
        return mailBox;
    }
 }
