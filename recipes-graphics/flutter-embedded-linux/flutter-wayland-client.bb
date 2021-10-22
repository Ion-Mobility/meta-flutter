SUMMARY = "Flutter embedding for eLinux with Wayland backend"
DESCRIPTION = "Build the flutter-wayland-client project"

require repository.inc
require dependency.inc

DEPENDS += "wayland \
            wayland-protocols \
            wayland-native"

SRC_URI += "file://0001-SURFACE-Need-to-create-at-leat-1-buffer-for-renderin.patch"

EXTRA_OECMAKE = "-DUSER_PROJECT_PATH=examples/flutter-wayland-client"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/build/flutter-client ${D}${bindir}
}

require tasks.inc
