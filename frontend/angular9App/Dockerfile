FROM nginx
RUN mkdir -p /etc/nginx/templates
COPY templates/default.conf.template /etc/nginx/templates
RUN rm -f /etc/nginx/conf.d/default.conf
ADD dist/angular9App /usr/share/nginx/html/
RUN ls -la /usr/share/nginx/html/
ENV NGINX_SERVER_NAME="frontend"
ENV NGINX_BACKEND_URL="http://backend:8080"