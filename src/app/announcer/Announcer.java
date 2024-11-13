package app.announcer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Announcer {
  Map<Class<? extends AbstractEvent>, List<Object>> registrationIndex;

  public Announcer() {
    registrationIndex = new HashMap<>();
  }

  public void register(Object o, Class<? extends AbstractEvent> eventClass) {
    List<Object> l = registrationIndex.computeIfAbsent(eventClass, k -> new ArrayList<>());
    l.add(o);
  }

  public void unregister(Object o, Class<? extends AbstractEvent> eventClass) {
    List<Object> l = registrationIndex.get(eventClass);
    l.removeIf(current -> o == current);
    if (l.isEmpty()) {
      registrationIndex.remove(eventClass);
    }
  }

  public void announce(AbstractEvent anEvent) {
    Class<?> eventClass = anEvent.getClass();
    List<Object> l = registrationIndex.get(eventClass);
    if (l == null) return;
    for (Object current : l) {
      anEvent.sentTo(current);
    }
  }
}
