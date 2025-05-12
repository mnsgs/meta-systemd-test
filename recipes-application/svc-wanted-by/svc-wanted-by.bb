DESCRIPTION = "TR600 Device Tree Overlays"
LICENSE = "CLOSED"

inherit systemd

SRC_URI = "file://${BPN}@.service"

SYSTEMD_SERVICE:${BPN} = "\
    ${BPN}@a.service \
    ${BPN}@b.service \
    "

do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${UNPACKDIR}/${BPN}@.service ${D}${systemd_system_unitdir}
}

FILES:${PN} += "${systemd_system_unitdir}"
