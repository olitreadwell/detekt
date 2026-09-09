# detekt/detekt context
> refreshed 2026-09-09 07:11 UTC | upstream default: main @ 733ac76c40

## Identity & policies
- upstream: detekt/detekt, default branch `main`, primary language Kotlin/JVM. English-first: yes (all issues, docs, maintainer conversation in English).
- CLA/DCO: none (no CLA bot or DCO sign-off found in CONTRIBUTING).
- AI-assisted PR policy: ALLOWED — CONTRIBUTING "A note on AI-generated contributions": "using AI tools to assist your PRs is perfectly fine and accepted." It discourages contributions that appear ENTIRELY AI-generated ("can create extra work for maintainers"). No AI disclosure required. Not a hard skip.
- signed commits required: no (no signature workflow found).
- PR template: `.github/PULL_REQUEST_TEMPLATE.md` (comments only, no checkboxes).
- external tracker: github (issues are on GitHub).

## Conventions (verified from merged PRs)
- branch naming: mixed, dominant human pattern is `type/desc` — `fix/...`, `feat/...`, `docs/...`, `nc/...`. (renovate/* is bots.)
- commit style: Conventional Commits `type(scope): subject` (e.g. `docs: separate Gradle setup by detekt version (#9656)`).
- test command: `./gradlew` (detektMain, detektTest). Docs-only changes have no Java test.
- CI gates merge; fork requires Actions enabled (fork CI).

## Maintainer picture
- active maintainer: `cortinico` (core). Responsive; responds on issues and PRs.
- in-flight maintainer PRs autoCorrect series `[1/6]-[4/6]` — avoid overlapping that work area.

## Issue-area health
- #8625 (test report behavior in OutputFacadeSpec) — fork PR #1 already open (`fix/8625-output-reports-spec-tests`).
- #9623 (`--friend-paths` missing-jar stacktrace) — claimed by upstream open PR #9626; DO NOT duplicate.
- #9269, #9137 (UnusedImport KMP false positives) — real but needs a real KMP project; not reproducible in sandbox.
- #9074 (NullableToStringCall false positive) — real; maintainer asked for a reproducer test; Gradle-platform-type case hard to reproduce in sandbox.
- #8783 (forbidden method config docs single source of truth) — open, `help wanted`, but spans whole website docs; risky scope.

## Gap ledger (dedupe — READ FIRST, never re-pick)
- 2026-09-09 issue #8625 (test report behavior) — pr-opened — fork PR #1 open; don't re-open same fix.
- 2026-09-09 issue #9623 (friend-paths) — dropped — upstream PR #9626 already open; don't duplicate.

- 2026-09-09 dead links (droidcon talk, ReportingExtension path, galler.dev article) — pr-opened — fork PR #21 (fix/talks-docs-dead-links), 2 files / 3-link fix, fork CI CLEAN. Don't re-pick these three.

## Mined gaps (discovered, not yet attempted)
- 2026-09-09 dead links in docs (README.md + website/src/pages/changelog.mdx), curl-re-verified: droidcon State-of-the-Union -> YouTube G8S8A2uSapM (404->200); ReportingExtension.kt old `io/gitlab/...` path (404->200 `dev/detekt/...`); galler.dev article NXDOMAIN -> Wayback snapshot. — status: attempted/pr-opened

