#
# TABLE STRUCTURE FOR: products
#

DROP TABLE IF EXISTS `products`;

CREATE TABLE `products` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `products_price_IDX` (`price`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `products` (`id`, `title`, `price`) VALUES ('1', 'est', '6241.48');
INSERT INTO `products` (`id`, `title`, `price`) VALUES ('2', 'rem', '7138.88');
INSERT INTO `products` (`id`, `title`, `price`) VALUES ('3', 'labore', '3597.81');
INSERT INTO `products` (`id`, `title`, `price`) VALUES ('4', 'dolorem', '6416.35');
INSERT INTO `products` (`id`, `title`, `price`) VALUES ('5', 'esse', '429.20');
INSERT INTO `products` (`id`, `title`, `price`) VALUES ('6', 'quia', '1365.82');
INSERT INTO `products` (`id`, `title`, `price`) VALUES ('7', 'inventore', '7727.18');
INSERT INTO `products` (`id`, `title`, `price`) VALUES ('8', 'pariatur', '5392.15');
INSERT INTO `products` (`id`, `title`, `price`) VALUES ('9', 'nostrum', '6175.20');
INSERT INTO `products` (`id`, `title`, `price`) VALUES ('10', 'atque', '4659.78');
INSERT INTO `products` (`id`, `title`, `price`) VALUES ('11', 'molestias', '3702.55');
INSERT INTO `products` (`id`, `title`, `price`) VALUES ('12', 'facilis', '5159.67');
INSERT INTO `products` (`id`, `title`, `price`) VALUES ('13', 'voluptas', '728.63');
INSERT INTO `products` (`id`, `title`, `price`) VALUES ('14', 'a', '4720.96');
INSERT INTO `products` (`id`, `title`, `price`) VALUES ('15', 'commodi', '8376.75');
INSERT INTO `products` (`id`, `title`, `price`) VALUES ('16', 'iste', '4963.87');
INSERT INTO `products` (`id`, `title`, `price`) VALUES ('17', 'rem', '5463.11');
INSERT INTO `products` (`id`, `title`, `price`) VALUES ('18', 'qui', '579.58');
INSERT INTO `products` (`id`, `title`, `price`) VALUES ('19', 'beatae', '8640.23');
INSERT INTO `products` (`id`, `title`, `price`) VALUES ('20', 'natus', '9106.60');
