# Socially — A Modern Social Networking App

Socially is a full-featured social networking application focused on delightful UX, smooth animations, and real-time interactions. Core features include user profiles, photo sharing, social feeds with likes and comments, ephemeral stories, direct messaging, follower management, and real-time notifications.

![Socially Cover](./docs/cover.png)

---

## ✨ Features

- **Auth & Profiles**
  - Email/password sign up & login, OAuth (Google) optional
  - Editable profiles, avatar/banner upload, bio, website, username handle
- **Feed & Posts**
  - Photo uploads (single/multi), captions, tags/mentions
  - Likes, comments, threaded replies, rich previews
  - Infinite scroll, pull-to-refresh, optimistic updates
- **Stories**
  - 24-hour ephemeral stories (images/video), viewer list, progress bars
- **Messaging**
  - 1:1 chats, typing indicators, read receipts, image sharing
  - Online/last-seen presence
- **Social Graph**
  - Follow / Unfollow, suggested users, followers/following lists
- **Notifications**
  - Realtime in-app toasts & inbox
  - Push notifications (mobile), email digests (optional)
- **Search & Discovery**
  - Search users, hashtags, and captions
  - Explore tab with trending posts/tags
- **Safety**
  - Block/report users, hide content, rate limiting, media moderation hooks
- **Delight**
  - Smooth page transitions, micro-interactions, haptic feedback (mobile)
  - Accessible UI, dark mode

---

## 🧰 Tech Stack

> **Mobile/Web Frontend**
- **React Native (Expo)** for iOS/Android
- **React Native Reanimated** & **Gesture Handler** for buttery animations
- **Zustand** (or Redux Toolkit) for local state
- **React Query** for server state & caching
- **NativeWind** (Tailwind for RN) for styling
- **Expo Router** for navigation
- **Expo Notifications** for push (mobile)

> **Backend**
- **Node.js + NestJS** (or Express) REST API
- **PostgreSQL** with **Prisma ORM**
- **Redis** for sessions, rate limits, notification fan-out
- **Socket.IO** for realtime chat/notifications/typing indicators
- **BullMQ** for background jobs (push/email digests, fan-out)
- **Zod**/class-validator for input validation
- **JWT** auth (access/refresh tokens), **Passport** strategies

> **Storage & Infra**
- **S3-compatible** (AWS S3 or **MinIO**) for media
- **ImgProxy/Thumbor** (optional) for image resizing
- **Docker Compose** for local dev
- **GitHub Actions** for CI (lint, test, typecheck)
- **ESLint + Prettier** for code quality

---

## 🏗️ Monorepo Structure

