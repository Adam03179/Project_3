<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="3.0"
        xmlns="http://www.deposits.com"
        xmlns:xsd="http://www.w3.org/2001/XMLSchema"
        xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
        xmlns:testSpace="http://www.testSpace.com">
    <xsl:template match="/">
        <html>
            <body>
                <h1>Bank</h1>
                <table border="4px groove black">
                    <tr bgcolor="#CCCCCC">
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
                            <td bgcolor="#F5F5F5">
                                <xsl:value-of select="@id"/>
                            </td>
                            <td bgcolor="#F5F5F5">
                                <xsl:value-of select="name"/>
                            </td>
                            <td bgcolor="#F5F5F5">
                                <xsl:value-of select="country"/>
                            </td>
                            <td bgcolor="#F5F5F5">
                                <xsl:value-of select="type"/>
                            </td>
                            <td bgcolor="#F5F5F5">
                                <xsl:value-of select="depositor/sex"/>
                            </td>
                            <td bgcolor="#F5F5F5">
                                <xsl:value-of select="depositor/age"/>
                            </td>
                            <td bgcolor="#F5F5F5">
                                <xsl:value-of select="depositor/first_name"/>
                            </td>
                            <td bgcolor="#F5F5F5">
                                <xsl:value-of select="depositor/last_name"/>
                            </td>
                            <td bgcolor="#F5F5F5">
                                <xsl:value-of select="account_id"/>
                            </td>
                            <td bgcolor="#F5F5F5">
                                <xsl:value-of select="amount_on_deposit/testSpace:dollars_USA"/>
                            </td>
                            <td bgcolor="#F5F5F5">
                                <xsl:value-of select="amount_on_deposit/testSpace:hrivnas"/>
                            </td>
                            <td bgcolor="#F5F5F5">
                                <xsl:value-of select="profitability"/>
                            </td>
                            <td bgcolor="#F5F5F5">
                                <xsl:value-of select="time_constraints/days"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>