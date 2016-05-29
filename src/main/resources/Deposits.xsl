<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <html>
            <body>
                <h1>Bank</h1>
                <table border="1">
                    <tr>
                        <th>Deposit</th>
                        <th>Name</th>
                        <th>Country</th>
                        <th>Type</th>
                        <th>Sex</th>
                        <th>Age</th>
                        <th>First name</th>
                        <th>Last name</th>
                        <th>Account</th>
                        <th>Dollars USA</th>
                        <th>Hrivnas UA</th>
                        <th>Profitability</th>
                        <th>Days</th>
                    </tr>
                    <xsl:for-each select="bank/deposit">
                        <tr>
                            <td>
                                <xsl:value-of select="deposit"/>
                            </td>
                            <td>
                                <xsl:value-of select="name"/>
                            </td>
                            <td>
                                <xsl:value-of select="country"/>
                            </td>
                            <td>
                                <xsl:value-of select="type"/>
                            </td>
                            <td>
                                <xsl:value-of select="depositor/sex"/>
                            </td>
                            <td>
                                <xsl:value-of select="depositor/age"/>
                            </td>
                            <td>
                                <xsl:value-of select="depositor/first_name"/>
                            </td>
                            <td>
                                <xsl:value-of select="depositor/last_name"/>
                            </td>
                            <td>
                                <xsl:value-of select="account_id"/>
                            </td>
                            <td>
                                <xsl:value-of select="amount_on_deposit/dollars_USA"/>
                            </td>
                            <td>
                                <xsl:value-of select="amount_on_deposit/hrivnas"/>
                            </td>
                            <td>
                                <xsl:value-of select="profitability"/>
                            </td>
                            <td>
                                <xsl:value-of select="time_constraints/days"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>