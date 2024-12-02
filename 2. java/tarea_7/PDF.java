package tarea_7;

public class PDF implements Documento {
  public int cnt_paginas;
  public String autor;
  public String titulo;
  public String genero;

  PDF(int cnt_paginas, String autor, String titulo, String genero){
    this.cnt_paginas = cnt_paginas;
    this.titulo = titulo;
    this.genero = genero;
    this.autor = autor;
  }

  @Override
  public void imprimir(){
    System.out.println("Titulo: " + titulo);
    System.out.println("Autor: " + autor);
    System.out.println("Paginas: " + cnt_paginas);
    System.out.println("Genero: " + genero);
    System.out.println();
  }
}
