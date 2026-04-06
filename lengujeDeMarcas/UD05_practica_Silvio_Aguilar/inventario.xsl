<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
      xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template match="/">

    <html>
      <head>
        <title>Reporte de Inventario de Productos</title>
        <style>
          body {
            font-family: Arial, sans-serif;
            margin: 40px;
            background-color: #f9f9f9;
          }
          h1 {
            color: #333366;
            border-bottom: 2px solid #333366;
            padding-bottom: 5px;
          }
          h2 {
            margin-top: 40px;
            color: #333;
          }
          table {
            width: 60%;
            border-collapse: collapse;
            margin-top: 20px;
          }
          th, td {
            border: 1px solid #ccc;
            padding: 8px;
            text-align: center;
          }
          th {
            background-color: #eeeeee;
          }
          ul {
            list-style-type: square;
            margin-top: 10px;
          }
        </style>
      </head>

      <body>
        <h1>Reporte de Inventario de Productos</h1>

        <p><strong>Nombre de la tienda:</strong>
          <xsl:value-of select="tienda/nombre"/>
        </p>
        <p><strong>Teléfono:</strong>
          <xsl:value-of select="tienda/telefono"/>
        </p>

        <!-- Tabla de productos marca Casio -->
        <h2>Productos de la marca Casio</h2>
        <table>
          <tr>
            <th>Código</th>
            <th>Artículo</th>
            <th>Marca</th>
            <th>Cantidad</th>
          </tr>

          <!-- Filtramos solo los productos Casio -->
          <xsl:for-each select="tienda/producto[marca='Casio']">
            <!-- Ordenamos por cantidad ascendente -->
            <xsl:sort select="cantidad" data-type="number" order="ascending"/>

            <tr>
              <td><xsl:value-of select="codigo"/></td>
              <td><xsl:value-of select="articulo"/></td>
              <td><xsl:value-of select="marca"/></td>

              <xsl:choose>
                <xsl:when test="cantidad &gt; 25">
                  <td style="background-color:#ffff66;">
                    <xsl:value-of select="cantidad"/>
                  </td>
                </xsl:when>
                <xsl:otherwise>
                  <td style="background-color:#99ff99;">
                    <xsl:value-of select="cantidad"/>
                  </td>
                </xsl:otherwise>
              </xsl:choose>
            </tr>
          </xsl:for-each>
        </table>

        <!-- Sección de otros productos con stock alto -->
        <h2>Otros Productos con Stock Elevado</h2>
        <ul>
          <xsl:for-each select="tienda/producto">
            <xsl:if test="cantidad &gt; 25">
              <li>
                <xsl:value-of select="articulo"/> 
                (<strong><xsl:value-of select="cantidad"/></strong> unidades)
              </li>
            </xsl:if>
          </xsl:for-each>
        </ul>
      </body>
    </html>

  </xsl:template>
</xsl:stylesheet>


<!-- 
  * Práctica UD5 Silvio Aguilar
  * Lenguaje de Marcas
  * 2025

-->
