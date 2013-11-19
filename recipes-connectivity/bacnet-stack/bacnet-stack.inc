DESCRIPTION = "BACnet open source protocol stack"
AUTHOR = "Steve Karg"
SECTION = "console"
LICENSE = "GPLv2"
PR = "r2"

inherit siteinfo pkgconfig

FILES_${PN} = " \
    ${bindir}/bacarf \
    ${bindir}/bacawf \
    ${bindir}/bacdcc \
    ${bindir}/bacepics \
    ${bindir}/baciamr \
    ${bindir}/bacinitr \
    ${bindir}/bacrd \
    ${bindir}/bacrp \
    ${bindir}/bacrpd.sh \
    ${bindir}/bacrpm \
    ${bindir}/bacscov \
    ${bindir}/bacserv \
    ${bindir}/bacts \
    ${bindir}/bacucov \
    ${bindir}/bacupt \
    ${bindir}/bacwh \
    ${bindir}/bacwi \
    ${bindir}/bacwir \
    ${bindir}/bacwp \
    ${bindir}/bacgateway \
    ${bindir}/bvlc.sh \
    ${bindir}/mstpcap \
    ${bindir}/mstpcrc \
    ${datadir}/readme.txt \
    "
    
FILES_${PN}-staticdev = " \
    ${libdir}/libbacnet.a \
    "

# Use the LDFLAGS settings already set by OE
TARGET_CC_ARCH += "${LDFLAGS}"

do_compile_append () {
    # Uncomment if you want to rebuild the documentation
    # doxygen BACnet-stack.doxyfile

    # Uncomment if you want to perform static analysis on the project
    # ./splint.sh
}

# Move all the binary files to /usr/bin
do_install () {
    install -d ${D}${bindir} ${D}${datadir} ${D}${libdir} ${STAGING_INCDIR}/${PN} 
    install -m 0755 ${S}/bin/bacarf ${D}${bindir}
    install -m 0755 ${S}/bin/bacawf ${D}${bindir}
    install -m 0755 ${S}/bin/bacdcc ${D}${bindir}
    install -m 0755 ${S}/bin/bacepics ${D}${bindir}
    install -m 0755 ${S}/bin/baciamr ${D}${bindir}
    install -m 0755 ${S}/bin/bacinitr ${D}${bindir}
    install -m 0755 ${S}/bin/bacrd ${D}${bindir}
    install -m 0755 ${S}/bin/bacrp ${D}${bindir}
    install -m 0755 ${S}/bin/bacrpd.sh ${D}${bindir}/bacrpd.sh
    install -m 0755 ${S}/bin/bacrpm ${D}${bindir}
    install -m 0755 ${S}/bin/bacscov ${D}${bindir}
    install -m 0755 ${S}/bin/bacserv ${D}${bindir}
    install -m 0755 ${S}/bin/bacts ${D}${bindir}
    install -m 0755 ${S}/bin/bacucov ${D}${bindir}
    install -m 0755 ${S}/bin/bacupt ${D}${bindir}
    install -m 0755 ${S}/bin/bacwh ${D}${bindir}
    install -m 0755 ${S}/bin/bacwi ${D}${bindir}
    install -m 0755 ${S}/bin/bacwir ${D}${bindir}
    install -m 0755 ${S}/bin/bacwp ${D}${bindir}
    install -m 0755 ${S}/bin/bacgateway ${D}${bindir}
    install -m 0755 ${S}/bin/bvlc.sh ${D}${bindir}
    install -m 0755 ${S}/bin/mstpcap ${D}${bindir}
    install -m 0755 ${S}/bin/mstpcrc ${D}${bindir}
    install -m 0644 ${S}/bin/readme.txt ${D}${datadir}
    install -m 0644 ${S}/lib/libbacnet.a ${D}${libdir}
    install -m 0644 ${S}/include/* ${STAGING_INCDIR}/${PN}
}
