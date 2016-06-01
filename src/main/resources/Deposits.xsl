<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
        xmlns="http://www.deposits.com"
        xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
        xmlns:testSpace="http://www.testSpace.com"
        exclude-result-prefixes="testSpace">
    <xsl:template match="/">
        <html>
            <body>
                <h1>Bank</h1>
                <table border="1">
                    <tr bgcolor="yellow">
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
                                <xsl:value-of select="@id"/>
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
                                <xsl:value-of select="amount_on_deposit/testSpace:dollars_USA"/>
                            </td>
                            <td>
                                <xsl:value-of select="amount_on_deposit/testSpace:hrivnas"/>
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