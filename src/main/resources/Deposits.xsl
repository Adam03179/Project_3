<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="3.0" xmlns:p="http://www.deposits.com"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:testSpace="http://www.testSpace.com">
    <xsl:template match="p:bank">
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
                    <xsl:apply-templates/>
                </table>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="p:deposit">
        <tr>
            <td bgcolor="#F5F5F5">
                <xsl:value-of select="@id"/>
            </td>
            <td bgcolor="#F5F5F5">
                <xsl:value-of select="p:name"/>
            </td>
            <td bgcolor="#F5F5F5">
                <xsl:value-of select="p:country"/>
            </td>
            <td bgcolor="#F5F5F5">
                <xsl:value-of select="p:type"/>
            </td>

            <xsl:apply-templates select="p:depositor"/>

            <td bgcolor="#F5F5F5">
                <xsl:value-of select="p:account_id"/>
            </td>

            <xsl:apply-templates select="p:amount_on_deposit"/>

            <td bgcolor="#F5F5F5">
                <xsl:value-of select="p:profitability"/>
            </td>
            <td bgcolor="#F5F5F5">
                <xsl:value-of select="p:time_constraints/p:days"/>
            </td>
        </tr>
    </xsl:template>

    <xsl:template match="p:depositor">
        <td bgcolor="#F5F5F5">
            <xsl:value-of select="p:sex"/>
        </td>
        <td bgcolor="#F5F5F5">
            <xsl:value-of select="p:age"/>
        </td>
        <td bgcolor="#F5F5F5">
            <xsl:value-of select="p:first_name"/>
        </td>
        <td bgcolor="#F5F5F5">
            <xsl:value-of select="p:last_name"/>
        </td>
    </xsl:template>

    <xsl:template match="p:amount_on_deposit">
        <td bgcolor="#F5F5F5">
            <xsl:value-of select="testSpace:dollars_USA"/>
        </td>
        <td bgcolor="#F5F5F5">
            <xsl:value-of select="testSpace:hrivnas"/>
        </td>
    </xsl:template>

</xsl:stylesheet>

