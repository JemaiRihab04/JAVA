<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

final class Version20251010195000 extends AbstractMigration
{
    public function getDescription(): string
    {
        return 'Création de la table book avec la clé étrangère author_id';
    }

    public function up(Schema $schema): void
    {
        $this->addSql('CREATE TABLE book (
            id INT AUTO_INCREMENT NOT NULL,
            enabled TINYINT(1) DEFAULT NULL,
            author_id INT NOT NULL,
            PRIMARY KEY(id)
        ) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');

        $this->addSql('ALTER TABLE book ADD CONSTRAINT FK_AUTHOR FOREIGN KEY (author_id) REFERENCES author (id)');
    }

    public function down(Schema $schema): void
    {
        $this->addSql('DROP TABLE book');
    }
}
