DESCRIPTION = "BACnet open source protocol stack"
AUTHOR = "Steve Karg"
SECTION = "console"
LICENSE = "GPLv2-BACNET-STACK"
PR = "r0"
LIC_FILES_CHKSUM = "file://license/gpl-2.txt;md5=3040850b26eed151876dcd4b841f5235"
RDEPENDS_${PN} = "bash"
DEPENDS = "virtual/kernel"

inherit pkgconfig

# The static library needs to be built before the demo applications are built.
# So, disable parallel make for this recipe to ensure all pieces build in the
# proper linear order.
PARALLEL_MAKE = ""

# Use this to grab latest revision from the bacnet-stack-0.9 branch
SRCNAME = "bacnet-stack-0.9"
SRCREV = "${SRCNAME}"
SRC_URI = "git://github.com/bacnet-stack/bacnet-stack;branch=${SRCNAME}"

# Use this to build the specific tagged revision that matches the recipe
# version name
#SRCREV = "${BP}"
#SRC_URI = "git://github.com/bacnet-stack/bacnet-stack"

# The Git repository

# Set the working directory
S = "${WORKDIR}/git"

# Set all the application binaries for installation
FILES_${PN} = " \
    ${bindir}/abort-reason.sh \
    ${bindir}/bacabort \
    ${bindir}/bacarf \
    ${bindir}/bacawf \
    ${bindir}/bacdcc \
    ${bindir}/bacepics \
    ${bindir}/bacerror \
    ${bindir}/bacge \
    ${bindir}/baciam \
    ${bindir}/baciamr \
    ${bindir}/bacinitr \
    ${bindir}/bacrbdt \
    ${bindir}/bacrd \
    ${bindir}/bacroute \
    ${bindir}/bacroute.sh \
    ${bindir}/bacrp \
    ${bindir}/bacrpd.sh \
    ${bindir}/bacrpm \
    ${bindir}/bacrr \
    ${bindir}/bacscov \
    ${bindir}/bacserv \
    ${bindir}/bacts \
    ${bindir}/bacucov \
    ${bindir}/bacuevent \
    ${bindir}/bacupt \
    ${bindir}/bacwh \
    ${bindir}/bacwi \
    ${bindir}/bacwir \
    ${bindir}/bacwp \
    ${bindir}/bacgateway \
    ${bindir}/bvlc.sh \
    ${bindir}/door-status.sh \
    ${bindir}/error-code.sh \
    ${bindir}/event-state.sh \
    ${bindir}/event-type.sh \
    ${bindir}/lock-status.sh \
    ${bindir}/mstpcap \
    ${bindir}/mstpcrc \
    ${bindir}/object-type.sh \
    ${bindir}/program-request.sh \
    ${bindir}/program-state.sh \
    ${bindir}/property_id.sh \
    ${bindir}/property-states.sh \
    ${datadir}/readme.txt \
    ${bindir}/reliability.sh \
    ${bindir}/restart-reason.sh \
    ${bindir}/units.sh \
    ${bindir}/vendor-id.sh \
    "

FILES_${PN}-staticdev = " \
    ${libdir}/libbacnet.a \
    "
    
# Use the LDFLAGS settings already set by OE
TARGET_CC_ARCH += "${LDFLAGS}"

do_compile () {
    # Build the static libary and the main demo applications
    make clean
    make all
    
    # Build the gateway demo, which means rebuilding the library
    make clean
    make gateway
}

do_compile_append_${PN} () {
    # Uncomment if you want to rebuild the documentation
    # doxygen BACnet-stack.doxyfile
}

# Move all the binary files to /usr/bin
do_install () {
    install -d ${D}${bindir} ${D}${datadir} ${D}${libdir} ${D}${incdir} 
    install -m 0755 ${S}/bin/abort-reason.sh ${D}${bindir}
    install -m 0755 ${S}/bin/bacabort ${D}${bindir}
    install -m 0755 ${S}/bin/bacarf ${D}${bindir}
    install -m 0755 ${S}/bin/bacawf ${D}${bindir}
    install -m 0755 ${S}/bin/bacdcc ${D}${bindir}
    install -m 0755 ${S}/bin/bacepics ${D}${bindir}
    install -m 0755 ${S}/bin/bacerror ${D}${bindir}
    install -m 0755 ${S}/bin/bacge ${D}${bindir}
    install -m 0755 ${S}/bin/baciam ${D}${bindir}
    install -m 0755 ${S}/bin/baciamr ${D}${bindir}
    install -m 0755 ${S}/bin/bacinitr ${D}${bindir}
    install -m 0755 ${S}/bin/bacrbdt ${D}${bindir}
    install -m 0755 ${S}/bin/bacrd ${D}${bindir}
    install -m 0755 ${S}/bin/bacroute ${D}${bindir}
    install -m 0755 ${S}/bin/bacroute.sh ${D}${bindir}
    install -m 0755 ${S}/bin/bacrp ${D}${bindir}
    install -m 0755 ${S}/bin/bacrpd.sh ${D}${bindir}/bacrpd.sh
    install -m 0755 ${S}/bin/bacrpm ${D}${bindir}
    install -m 0755 ${S}/bin/bacrr ${D}${bindir}
    install -m 0755 ${S}/bin/bacscov ${D}${bindir}
    install -m 0755 ${S}/bin/bacserv ${D}${bindir}
    install -m 0755 ${S}/bin/bacts ${D}${bindir}
    install -m 0755 ${S}/bin/bacucov ${D}${bindir}
    install -m 0755 ${S}/bin/bacuevent ${D}${bindir}
    install -m 0755 ${S}/bin/bacupt ${D}${bindir}
    install -m 0755 ${S}/bin/bacwh ${D}${bindir}
    install -m 0755 ${S}/bin/bacwi ${D}${bindir}
    install -m 0755 ${S}/bin/bacwir ${D}${bindir}
    install -m 0755 ${S}/bin/bacwp ${D}${bindir}
    install -m 0755 ${S}/bin/bacgateway ${D}${bindir}
    install -m 0755 ${S}/bin/bvlc.sh ${D}${bindir}
    install -m 0755 ${S}/bin/door-status.sh ${D}${bindir}
    install -m 0755 ${S}/bin/error-code.sh ${D}${bindir}
    install -m 0755 ${S}/bin/event-state.sh ${D}${bindir}
    install -m 0755 ${S}/bin/event-type.sh ${D}${bindir}
    install -m 0755 ${S}/bin/lock-status.sh ${D}${bindir}
    install -m 0755 ${S}/bin/mstpcap ${D}${bindir}
    install -m 0755 ${S}/bin/mstpcrc ${D}${bindir}
    install -m 0755 ${S}/bin/object-type.sh ${D}${bindir}
    install -m 0755 ${S}/bin/program-request.sh ${D}${bindir}
    install -m 0755 ${S}/bin/program-state.sh ${D}${bindir}
    install -m 0755 ${S}/bin/property_id.sh ${D}${bindir}
    install -m 0755 ${S}/bin/property-states.sh ${D}${bindir}
    install -m 0644 ${S}/bin/readme.txt ${D}${datadir}
    install -m 0755 ${S}/bin/reliability.sh ${D}${bindir}
    install -m 0755 ${S}/bin/restart-reason.sh ${D}${bindir}
    install -m 0755 ${S}/bin/units.sh ${D}${bindir}
    install -m 0755 ${S}/bin/vendor-id.sh ${D}${bindir}
    install -m 0644 ${S}/lib/libbacnet.a ${D}${libdir}
}
        
