PUT /zapatillas_deportivas
{
  "mappings": {
    "properties": {
      "nombre": { "type": "text" },
      "marca": { "type": "keyword" },
      "talla": { "type": "float" },
      "precio": { "type": "float" },
      "color": { "type": "keyword" },
      "tipo_de_uso": { "type": "keyword" },
      "stock": { "type": "integer" },
      "fecha_de_lanzamiento": { "type": "date", "format": "yyyy-MM-dd" }
    }
  }
}

POST /_bulk
{ "index": { "_index": "zapatillas_deportivas" }}
{ "nombre": "Air Zoom", "marca": "Nike", "talla": 42.5, "precio": 120.99, "color": "Negro", "tipo_de_uso": "Running", "stock": 10, "fecha_de_lanzamiento": "2023-08-15" }
{ "index": { "_index": "zapatillas_deportivas" }}
{ "nombre": "Ultraboost", "marca": "Adidas", "talla": 41, "precio": 150.00, "color": "Blanco", "tipo_de_uso": "Running", "stock": 8, "fecha_de_lanzamiento": "2023-06-20" }
{ "index": { "_index": "zapatillas_deportivas" }}
{ "nombre": "Air Zoom", "marca": "Nike", "talla": 42.5, "precio": 120.99, "color": "Negro", "tipo_de_uso": "Running", "stock": 10, "fecha_de_lanzamiento": "2023-08-15" }
{ "index": { "_index": "zapatillas_deportivas" }}
{ "nombre": "Ultraboost", "marca": "Adidas", "talla": 41, "precio": 150.00, "color": "Blanco", "tipo_de_uso": "Running", "stock": 8, "fecha_de_lanzamiento": "2023-06-20" }
{ "index": { "_index": "zapatillas_deportivas" }}
{ "nombre": "Gel-Kayano", "marca": "Asics", "talla": 43, "precio": 110.50, "color": "Azul", "tipo_de_uso": "Trail", "stock": 15, "fecha_de_lanzamiento": "2022-11-10" }
{ "index": { "_index": "zapatillas_deportivas" }}
{ "nombre": "FuelCell", "marca": "New Balance", "talla": 42, "precio": 140.25, "color": "Gris", "tipo_de_uso": "Running", "stock": 5, "fecha_de_lanzamiento": "2023-01-15" }
{ "index": { "_index": "zapatillas_deportivas" }}
{ "nombre": "Wave Rider", "marca": "Mizuno", "talla": 40, "precio": 105.99, "color": "Rojo", "tipo_de_uso": "Trail", "stock": 12, "fecha_de_lanzamiento": "2023-05-01" }
{ "index": { "_index": "zapatillas_deportivas" }}
{ "nombre": "Metcon", "marca": "Nike", "talla": 41, "precio": 130.00, "color": "Verde", "tipo_de_uso": "Training", "stock": 9, "fecha_de_lanzamiento": "2023-03-10" }
{ "index": { "_index": "zapatillas_deportivas" }}
{ "nombre": "Cloudflow", "marca": "On", "talla": 42.5, "precio": 170.99, "color": "Blanco", "tipo_de_uso": "Running", "stock": 7, "fecha_de_lanzamiento": "2023-04-20" }
{ "index": { "_index": "zapatillas_deportivas" }}
{ "nombre": "Speedgoat", "marca": "Hoka", "talla": 44, "precio": 160.00, "color": "Amarillo", "tipo_de_uso": "Trail", "stock": 6, "fecha_de_lanzamiento": "2022-12-15" }
{ "index": { "_index": "zapatillas_deportivas" }}
{ "nombre": "Pegasus", "marca": "Nike", "talla": 40.5, "precio": 120.00, "color": "Negro", "tipo_de_uso": "Running", "stock": 14, "fecha_de_lanzamiento": "2023-02-05" }
{ "index": { "_index": "zapatillas_deportivas" }}
{ "nombre": "Revolution", "marca": "Nike", "talla": 42, "precio": 70.50, "color": "Gris", "tipo_de_uso": "Casual", "stock": 20, "fecha_de_lanzamiento": "2023-07-01" }
{ "index": { "_index": "zapatillas_deportivas" }}
{ "nombre": "Nemeziz", "marca": "Adidas", "talla": 43.5, "precio": 180.00, "color": "Naranja", "tipo_de_uso": "Fútbol", "stock": 10, "fecha_de_lanzamiento": "2023-06-15" }
{ "index": { "_index": "zapatillas_deportivas" }}
{ "nombre": "Predator", "marca": "Adidas", "talla": 42, "precio": 200.00, "color": "Negro", "tipo_de_uso": "Fútbol", "stock": 4, "fecha_de_lanzamiento": "2023-08-25" }
{ "index": { "_index": "zapatillas_deportivas" }}
{ "nombre": "Vapor Edge", "marca": "Nike", "talla": 41.5, "precio": 250.99, "color": "Blanco", "tipo_de_uso": "Fútbol Americano", "stock": 8, "fecha_de_lanzamiento": "2023-05-30" }
{ "index": { "_index": "zapatillas_deportivas" }}
{ "nombre": "Ghost", "marca": "Brooks", "talla": 42, "precio": 130.00, "color": "Azul", "tipo_de_uso": "Running", "stock": 10, "fecha_de_lanzamiento": "2023-07-15" }
{ "index": { "_index": "zapatillas_deportivas" }}
{ "nombre": "Hyperion", "marca": "Brooks", "talla": 41, "precio": 150.00, "color": "Amarillo", "tipo_de_uso": "Running", "stock": 6, "fecha_de_lanzamiento": "2023-03-01" }
{ "index": { "_index": "zapatillas_deportivas" }}
{ "nombre": "AlphaFly", "marca": "Nike", "talla": 44.5, "precio": 275.50, "color": "Rojo", "tipo_de_uso": "Running", "stock": 3, "fecha_de_lanzamiento": "2023-01-01" }
{ "index": { "_index": "zapatillas_deportivas" }}
{ "nombre": "Clifton", "marca": "Hoka", "talla": 42, "precio": 160.00, "color": "Gris", "tipo_de_uso": "Running", "stock": 8, "fecha_de_lanzamiento": "2023-06-10" }
{ "index": { "_index": "zapatillas_deportivas" }}
{ "nombre": "NovaBlast", "marca": "Asics", "talla": 40, "precio": 130.00, "color": "Verde", "tipo_de_uso": "Running", "stock": 12, "fecha_de_lanzamiento": "2023-07-05" }
{ "index": { "_index": "zapatillas_deportivas" }}
{ "nombre": "Wave Sky", "marca": "Mizuno", "talla": 43, "precio": 190.00, "color": "Azul", "tipo_de_uso": "Running", "stock": 5, "fecha_de_lanzamiento": "2023-04-15" }
{ "index": { "_index": "zapatillas_deportivas" }}
{ "nombre": "Sense Ride", "marca": "Salomon", "talla": 42.5, "precio": 180.00, "color": "Negro", "tipo_de_uso": "Trail", "stock": 10, "fecha_de_lanzamiento": "2023-02-28" }



GET /zapatillas_deportivas/_search
{
  "query": {
    "match": {
      "marca": "Nike"
    }
  }
}

GET /zapatillas_deportivas/_search
{
  "query": {
    "bool": {
      "must": [
        {
          "match": {
            "marca": "Nike"
          }
        },
        {
          "range": {
            "fecha_de_lanzamiento": {
              "gte": "2023-03-28",
              "lte": "2023-10-28"
            }
          }
        }
      ]
    }
  }
}


GET /zapatillas_deportivas/_search
{
  "query": {
    "range": {
      "talla": {
        "gte": 40,
        "lte": 41
      }
    }
  }
}