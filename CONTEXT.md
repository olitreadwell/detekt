# detekt/detekt context
> refreshed 2026-09-30 00:00 UTC | upstream default: main @ ee1c04f2d7

## Identity & policies
- upstream: detekt/detekt, default branch `main`, primary language Kotlin/JVM. English-first: yes (all issues, docs, maintainer conversation in English).
- CLA/DCO: none (no CLA bot or DCO sign-off found in CONTRIBUTING).
- AI-assisted PR policy: ALLOWED — CONTRIBUTING "A note on AI-generated contributions": "using AI tools to assist your PRs is perfectly fine and accepted." It discourages contributions that appear ENTIRELY AI-generated ("can create extra work for maintainers"). No AI disclosure required. Not a hard skip.
  - update 2026-09-30: `AGENTS.md` (and its `CLAUDE.md` symlink) additionally asks AI agents for a `Co-authored-by:` trailer and to "Clearly indicate AI involvement in the PR description". The policy passport says `ai_disclosure_required: false`, and the pipeline keeps fork PR bodies/commits free of AI mentions (Oli discloses at manual upstream promotion), so fork PR #47 has neither. Flag for Oli if a maintainer ever asks; detekt also explicitly says "Trivial changes should be bundled appropriately", which the 9-file bundled pass matches.
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

- #9721 (MissingUseCall false positive on separated usage) — real, reproducible, fixed in fork PR (branch `fix/missing-use-call-separated-usage`): `val repo = createGitRepository(); repo.use(block)` was spuriously flagged. Verified repro before fix; 3 new specs; module tests + detektMain/detektTest green. Maintainer `dzirbel` engaged. Known related limitation (not fixed): `checkNotNull(closeableVariable).use {}` indirection still flagged — deeper dataflow, left as follow-up (issue #9122 handled the inline-call form).

## Gap ledger (dedupe — READ FIRST, never re-pick)
- 2026-09-09 issue #8625 (test report behavior) — pr-opened — fork PR #1 open; don't re-open same fix.
- 2026-09-09 issue #9623 (friend-paths) — dropped — upstream PR #9626 already open; don't duplicate.

- 2026-09-09 dead links (droidcon talk, ReportingExtension path, galler.dev article) — pr-opened — fork PR #21 (fix/talks-docs-dead-links), 2 files / 3-link fix, fork CI CLEAN. Don't re-pick these three.
- 2026-09-25 issue #9721 (MissingUseCall separated-usage false positive) — pr-opened — fork PR (fix/missing-use-call-separated-usage): do not report when a Closeable assigned to a local property is later used with `use`. Don't re-pick.
- 2026-09-30 trivial-fix pass (dead links + typos) — pr-opened — fork PR #47 (`docs/fix-broken-links-and-typos`), 9 files / 10 fixes, meaning-preserving only: 3x `type-resolution.md` → `.mdx` (old target 404, new 200), CONTRIBUTING link ref `[2]` `Finding.kt` → `Findings.kt` (404 → 200), plus typos in `baseline.mdx`, `git-pre-commit-hook.mdx`, `gradle.mdx`, `marketplace.js`, `SuspendFunSwallowedCancellation.kt`, `XmlEscape.kt`, `UnnecessaryReversed.kt`. Verified: curl on every target, `node website/scripts/generate-docs.mjs` clean on the branch; local Gradle compile impossible in this box (2 GB cgroup OOM-kills the daemon), so the Kotlin change is comment/string-only and CI is the check. Don't re-pick these. versioned_docs/** left alone on purpose (historical snapshots).

## Mined gaps (discovered, not yet attempted)
- 2026-09-09 dead links in docs (README.md + website/src/pages/changelog.mdx), curl-re-verified: droidcon State-of-the-Union -> YouTube G8S8A2uSapM (404->200); ReportingExtension.kt old `io/gitlab/...` path (404->200 `dev/detekt/...`); galler.dev article NXDOMAIN -> Wayback snapshot. — status: attempted/pr-opened

