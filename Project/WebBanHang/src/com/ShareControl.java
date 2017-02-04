package com;

public interface ShareControl {
    //Chia se bo quan ly ket noi giua cac doi tuong basic voi nhau
  public ConnectionPool getConnectionPool();
  //Ra lenh cac doi tuong tra ve ket noi
  public void releaseConnection();
}
