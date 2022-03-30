
package ch01.Observer;

public interface Subject {
  void registerObserver(Observer o) ;

  void removeObserver(Observer o) ;

  void notifyObservers() ;

}
