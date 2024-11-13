package app.announcer;

interface AbstractEvent<T> {
  void sentTo(T listener);
}