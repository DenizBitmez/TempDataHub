FROM ubuntu:latest
LABEL authors="deniz"

ENTRYPOINT ["top", "-b"]