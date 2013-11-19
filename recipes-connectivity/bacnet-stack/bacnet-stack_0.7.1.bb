require bacnet-stack.inc
LIC_FILES_CHKSUM = "file://license/gpl-2.txt;md5=eb723b61539feef013de476e68b5c50a"
DEPENDS = "virtual/kernel"
# The executables need the static library loaded to run
RPROVIDES_${PN} = "${PN}-staticdev"
RDEPENDS_${PN} = "${PN}-staticdev"
PV_SRC_URI := "0-7-1"

SRC_URI = "svn://svn.code.sf.net/p/bacnet/code/tags;module=bacnet-stack-${PV_SRC_URI};rev=HEAD;protocol=http \
        file://0001-Adjusted-makefiles-for-cross-compile.patch \
        file://0002-Modified-splint-settings.patch \
        "        

WORKDIR = "${TMPDIR}/work/${MULTIMACH_TARGET_SYS}/${PN}"
S = "${WORKDIR}/${PN}-${PV_SRC_URI}"
        
