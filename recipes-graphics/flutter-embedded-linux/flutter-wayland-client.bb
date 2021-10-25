SUMMARY = "Flutter embedding for eLinux with Wayland backend"
DESCRIPTION = "Build the flutter-wayland-client project"

require repository.inc
require dependency.inc

DEPENDS += "wayland \
            wayland-protocols \
            wayland-native"

EXTRA_OECMAKE = "-DUSER_PROJECT_PATH=examples/flutter-wayland-client"

# Set the number of buffering before render for wayland backend
TARGET_CFLAGS += "-DBUF_NUM_SWAP_INTERVAL=1"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/build/flutter-client ${D}${bindir}
}

require tasks.inc
