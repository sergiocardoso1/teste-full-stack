export class Cerveja {

  public id: string;
  public name: string;
  public abv: number;
  public tagline: string;
  public image_url : string;
    // Note: Using only optional constructor properties without backing store disables typescript's type checking for the type
    constructor(id: string, name: string, abv: number, tagline: string, image_url: string) {

        this.id = id;
        this.name = name;
        this.abv = abv;
        this.tagline = tagline;
        this.image_url = image_url;

    }

    [key: string]: any; // Índice de assinatura



}
