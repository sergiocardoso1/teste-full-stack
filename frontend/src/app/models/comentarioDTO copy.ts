export class ComentarioDTO {

  public comentario: string;
  public cervejaId: number;

    // Note: Using only optional constructor properties without backing store disables typescript's type checking for the type
    constructor(comentario: string, cervejaId: number) {

        this.comentario = comentario;
        this.cervejaId = cervejaId;
 

    }

    [key: string]: any; // Índice de assinatura



}
