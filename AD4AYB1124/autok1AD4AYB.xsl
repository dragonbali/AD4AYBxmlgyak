<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html>
      <body>
        <h2>Határozza meg az autók rendszámát és árát az ár szerinti sorrendben előállító listát!</h2>
        <table border="1">
          <tr bgcolor="#9acd32">
            <th>Autók rendszámai</th>
            <th>Autók árai</th>
          </tr>
          <tr>
            <xsl:for-each select="autok/auto">
              <xsl:sort select="ar"></xsl:sort>
              <tr>
                <td><xsl:value-of select="@*"/></td>
                <td><xsl:value-of select="ar"/></td>
              </tr>
            </xsl:for-each>
          </tr>
        </table>
      </body>
    </html>
  </xsl:template>
  
</xsl:stylesheet>