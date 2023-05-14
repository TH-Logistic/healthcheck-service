# shellcheck disable=SC2154
VERSION=latest
docker build --tag registry.thinhlh.com/healthcheck_service:"$VERSION" --platform linux/amd64 .
docker push registry.thinhlh.com/healthcheck_service:"$VERSION"