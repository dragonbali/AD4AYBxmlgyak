<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html>
      <body>
        <h2>Kérdezze le mennyi autó drágább mint, 30000!</h2>
        <table border="1">
          <tr bgcolor="#9acd32">
            <th>Autók rendszámai</th>
            <th>Autók árai</th>
          </tr>
          <tr>
            <xsl:for-each select="autok/auto">
              <tr>
                <xsl:if test="ar &gt; 30000">
                <td><xsl:value-of select="@*"/></td>
                <td><xsl:value-of select="ar"/></td>
                </xsl:if>
              </tr>
            </xsl:for-each>
          </tr>
        </table>
      </body>
    </html>
  </xsl:template>
  
</xsl:stylesheet>